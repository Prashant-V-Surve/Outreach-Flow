package com.subspace.outreachflow.service;

import com.subspace.outreachflow.client.BrevoClient;
import com.subspace.outreachflow.model.CampaignEmail;
import com.subspace.outreachflow.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class PipelineService {

    private static final Logger log =
            LoggerFactory.getLogger(PipelineService.class);

    private final ContactDiscoveryService contactService;
    private final EmailCampaignService emailService;
    private final BrevoClient brevoClient;

    public void run(String domain) {

        Contact contact =
                contactService.findFirstVerifiedContact(domain);

        CampaignEmail email =
                emailService.createEmail(contact);

        log.info("Email preview generated");
        System.out.println(email);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nSend email? (yes/no): ");

        String answer = scanner.nextLine();

        if (!"yes".equalsIgnoreCase(answer)) {

            System.out.println("Email cancelled.");

            return;
        }

        // Error Handling

        try {

            brevoClient.sendEmail(
                    email,
                    "prashant.surve@outreachflow.cyou");

            log.info("Email sent successfully");

        } catch (Exception e) {

            log.error(
                    "Failed to send email",
                    e);
        }
    }
}