package com.example.productapiservice.service;

import com.example.productapiservice.dto.TaxRequest;
import com.example.productapiservice.dto.TaxResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaxServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${tax.service.url}")
    private String taxServiceUrl;

    public TaxResponse calculateTax(String countryCode, double income){
        TaxRequest req = new TaxRequest(countryCode, income);
        return restTemplate.postForObject(
                taxServiceUrl + "/tax/calculate",
                req,
                TaxResponse.class
        );
    }
}
