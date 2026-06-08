package com.subspace.outreachflow.dto;

import lombok.Data;

@Data
public class EnrichPersonResponse {

    private boolean error;
    private Person person;

    @Data
    public static class Person {

        private String first_name;
        private String last_name;
        private String linkedin_url;
        private String current_job_title;

        private Email email;

    }

    @Data
    public static class Email {

        private String email;
        private String status;

    }
}