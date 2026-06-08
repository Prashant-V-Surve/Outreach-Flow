package com.subspace.outreachflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignEmail {

    private String recipient;
    private String subject;
    private String body;
}