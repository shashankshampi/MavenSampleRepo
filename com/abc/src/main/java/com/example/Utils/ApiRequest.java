package com.example.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.logging.Logger;

public class ApiRequest {
    private static final Logger logger = Logger.getLogger(ApiRequest.class.getName());

    public void setup(String baseurl) {
        RestAssured.baseURI = baseurl;
    }

    public Response getRequest(String uri) {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(uri)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return response;

    }

    public Response getRequest(String uri, HashMap<String, Object> header) {

        Response response = RestAssured.given()
                .headers(header)
                .when()
                .get(uri)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return response;
    }

    public Response postRequest(String uri, String body) {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(uri)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return response;
    }

    public Response putRequest(String uri, String body) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .put(uri)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return response;

    }
}
