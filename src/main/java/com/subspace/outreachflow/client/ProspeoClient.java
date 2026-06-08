package com.subspace.outreachflow.client;

import com.subspace.outreachflow.dto.EnrichPersonRequest;
import com.subspace.outreachflow.dto.EnrichPersonResponse;
import com.subspace.outreachflow.dto.SearchPersonRequest;
import com.subspace.outreachflow.dto.SearchPersonResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Component
public class ProspeoClient {

    private final RestClient restClient;

    @Value("${prospeo.api.key}")
    private String apiKey;

    public ProspeoClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public SearchPersonResponse searchByDomain(String domain) {

        SearchPersonRequest request =
                new SearchPersonRequest();

        request.setPage(1);

        request.setFilters(
                Map.of(
                        "company",
                        Map.of(
                                "websites",
                                Map.of(
                                        "include",
                                        List.of(domain)
                                )
                        )
                )
        );

        return restClient.post()
                .uri("https://api.prospeo.io/search-person")
                .header("X-KEY", apiKey)
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(SearchPersonResponse.class);
    }

    public EnrichPersonResponse enrichPerson(String personId) {

        EnrichPersonRequest request =
                new EnrichPersonRequest();

        EnrichPersonRequest.DataRequest data =
                new EnrichPersonRequest.DataRequest();

        data.setPerson_id(personId);

        request.setData(data);

        return restClient.post()
                .uri("https://api.prospeo.io/enrich-person")
                .header("X-KEY", apiKey)
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(EnrichPersonResponse.class);
    }
}