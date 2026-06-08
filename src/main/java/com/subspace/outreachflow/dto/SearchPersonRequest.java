package com.subspace.outreachflow.dto;

import lombok.Data;
import java.util.Map;

@Data
public class SearchPersonRequest {

    private Integer page;
    private Map<String, Object> filters;

}