package com.example.productapiservice.controller;

import com.example.productapiservice.dto.ProductTaxCalculationRequest;
import com.example.productapiservice.dto.TaxResponse;
import com.example.productapiservice.service.TaxServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private TaxServiceClient taxServiceClient;

    @PostMapping("/calculateTax")
    public ResponseEntity<?> calculateTax(@RequestBody ProductTaxCalculationRequest request){
        if(!"US".equalsIgnoreCase(request.getProductCountry())){
            return ResponseEntity.ok("Microservice not invoked: product is not US-based.");
        }
        TaxResponse resp = taxServiceClient.calculateTax(
                request.getCounterpartyCountryCode(),
                request.getIncome()
        );
        return ResponseEntity.ok(resp);
    }
}
