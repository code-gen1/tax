package com.example.productapiservice.dto;

public class TaxRequest {
    private String countryCode;
    private double income;

    public TaxRequest() {}

    public TaxRequest(String countryCode, double income) {
        this.countryCode = countryCode;
        this.income = income;
    }

    public String getCountryCode() {return countryCode;}
    public void setCountryCode(String countryCode){this.countryCode = countryCode;}
    public double getIncome(){return income;}
    public void setIncome(double income){this.income = income;}
}
