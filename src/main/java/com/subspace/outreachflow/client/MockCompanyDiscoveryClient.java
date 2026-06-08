package com.subspace.outreachflow.client;

import com.subspace.outreachflow.model.Company;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockCompanyDiscoveryClient
        implements CompanyDiscoveryClient {

    @Override
    public List<Company> findSimilarCompanies(String domain) {

        return List.of(
                new Company("Shopify", "shopify.com"),
                new Company("Wise", "wise.com"),
                new Company("Airwallex", "airwallex.com")
        );
    }
}