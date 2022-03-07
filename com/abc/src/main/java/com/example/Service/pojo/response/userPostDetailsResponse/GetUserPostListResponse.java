package com.example.Service.pojo.response.userPostDetailsResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data

public class GetUserPostListResponse {

    @JsonProperty("data")
    private List<Datum> data = null;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("limit")
    private Integer limit;

}
