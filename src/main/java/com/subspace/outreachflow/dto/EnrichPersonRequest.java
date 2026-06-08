package com.subspace.outreachflow.dto;

import lombok.Data;

@Data
public class EnrichPersonRequest {

    private boolean only_verified_email = true;

    private DataRequest data;

    @Data
    public static class DataRequest {

        private String person_id;

    }
}