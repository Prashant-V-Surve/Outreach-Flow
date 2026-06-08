package com.subspace.outreachflow.service;

import com.subspace.outreachflow.model.CampaignEmail;
import com.subspace.outreachflow.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class EmailCampaignService {

    public CampaignEmail createEmail(Contact contact) {

        String subject =
                "Quick question for " +
                        contact.getFirstName();

        String body =
                "Hi " + contact.getFirstName() + ",\n\n" +
                        "I noticed you are working as " +
                        contact.getTitle() + ".\n\n" +
                        "I'd love to connect and learn more about your work.\n\n" +
                        "Best Regards,\n" +
                        "Prashant";

        return new CampaignEmail(
                contact.getEmail(),
                subject,
                body
        );
    }
}