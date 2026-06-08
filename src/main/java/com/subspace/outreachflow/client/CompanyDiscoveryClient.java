package com.subspace.outreachflow.client;

import com.subspace.outreachflow.model.Company;

import java.util.List;

public interface CompanyDiscoveryClient {

    List<Company> findSimilarCompanies(String domain);

}