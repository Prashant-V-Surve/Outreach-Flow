package com.subspace.outreachflow.dto;

import lombok.Data;

import java.util.List;

@Data
public class SendEmailRequest {

    private Sender sender;
    private List<Recipient> to;
    private String subject;
    private String htmlContent;

    @Data
    public static class Sender {
        private String name;
        private String email;
    }

    @Data
    public static class Recipient {
        private String email;
    }
}