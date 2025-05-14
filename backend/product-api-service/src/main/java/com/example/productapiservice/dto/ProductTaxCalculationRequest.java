package com.example.productapiservice.dto;

public class ProductTaxCalculationRequest {
    private String productCountry;
    private String counterpartyCountryCode;
    private double income;

    public String getProductCountry(){return productCountry;}
    public void setProductCountry(String productCountry){this.productCountry = productCountry;}
    public String getCounterpartyCountryCode(){return counterpartyCountryCode;}
    public void setCounterpartyCountryCode(String counterpartyCountryCode){this.counterpartyCountryCode = counterpartyCountryCode;}
    public double getIncome(){return income;}
    public void setIncome(double income){this.income = income;}
}
