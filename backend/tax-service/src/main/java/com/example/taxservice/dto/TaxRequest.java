package com.example.taxservice.dto;

public class TaxRequest {
    private String countryCode;
    private double income;
    public String getCountryCode() { return countryCode;}
    public void setCountryCode(String countryCode){this.countryCode = countryCode;}
    public double getIncome(){return income;}
    public void setIncome(double income){this.income=income;}
}
