package com.example.taxservice.controller;

import com.example.taxservice.dto.TaxRequest;
import com.example.taxservice.dto.TaxResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/tax")
public class TaxController {

    private static final Map<String, Double> RATES = Map.of(
            "FR", 0.15,
            "GR", 0.15,
            "CN", 0.10
    );

    @PostMapping("/calculate")
    public ResponseEntity<TaxResponse> calculate(@RequestBody TaxRequest request){
        double rate = RATES.getOrDefault(request.getCountryCode().toUpperCase(), 0.30);
        double tax = request.getIncome() * rate;
        return ResponseEntity.ok(new TaxResponse(tax));
    }
}
