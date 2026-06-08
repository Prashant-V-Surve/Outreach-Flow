package com.subspace.outreachflow.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchPersonResponse {

    private boolean error;
    private List<Result> results;

    @Data
    public static class Result {

        private Person person;

    }

    @Data
    public static class Person {

        private String person_id;
        private String first_name;
        private String last_name;
        private String linkedin_url;

    }
}