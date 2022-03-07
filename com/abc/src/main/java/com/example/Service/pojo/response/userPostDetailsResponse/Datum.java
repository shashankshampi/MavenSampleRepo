package com.example.Service.pojo.response.userPostDetailsResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Datum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("image")
    private String image;
    @JsonProperty("likes")
    private Integer likes;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("text")
    private String text;
    @JsonProperty("publishDate")
    private String publishDate;
    @JsonProperty("owner")
    private Owner owner;

}
