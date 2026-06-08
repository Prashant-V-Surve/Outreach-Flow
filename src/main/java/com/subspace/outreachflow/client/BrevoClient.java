package com.subspace.outreachflow.client;

import com.subspace.outreachflow.dto.SendEmailRequest;
import com.subspace.outreachflow.model.CampaignEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class BrevoClient {

    private final RestClient restClient;

    @Value("${brevo.api.key}")
    private String apiKey;

    public BrevoClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void sendEmail(CampaignEmail campaignEmail,
                          String senderEmail) {

        SendEmailRequest request =
                new SendEmailRequest();

        SendEmailRequest.Sender sender =
                new SendEmailRequest.Sender();

        sender.setName("Prashant");
        sender.setEmail(senderEmail);

        SendEmailRequest.Recipient recipient =
                new SendEmailRequest.Recipient();

        recipient.setEmail(
                campaignEmail.getRecipient());

        request.setSender(sender);
        request.setTo(List.of(recipient));
        request.setSubject(
                campaignEmail.getSubject());

        request.setHtmlContent(
                campaignEmail.getBody()
                        .replace("\n", "<br>")
        );

        restClient.post()
                .uri("https://api.brevo.com/v3/smtp/email")
                .header("api-key", apiKey)
                .header("Content-Type",
                        "application/json")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }
}