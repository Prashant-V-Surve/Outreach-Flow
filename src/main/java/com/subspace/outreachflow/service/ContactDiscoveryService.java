package com.subspace.outreachflow.service;

import com.subspace.outreachflow.client.ProspeoClient;
import com.subspace.outreachflow.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactDiscoveryService {

    private final ProspeoClient prospeoClient;

    public ContactDiscoveryService(
            ProspeoClient prospeoClient) {
        this.prospeoClient = prospeoClient;
    }

    public Contact findFirstVerifiedContact(
            String domain) {

        var searchResponse =
                prospeoClient.searchByDomain(domain);

        String personId =
                searchResponse.getResults()
                        .get(0)
                        .getPerson()
                        .getPerson_id();

        var enrichResponse =
                prospeoClient.enrichPerson(personId);

        return new Contact(
                enrichResponse.getPerson().getFirst_name(),
                enrichResponse.getPerson().getLast_name(),
                enrichResponse.getPerson().getCurrent_job_title(),
                enrichResponse.getPerson()
                        .getEmail()
                        .getEmail(),
                enrichResponse.getPerson()
                        .getLinkedin_url()
        );
    }

}