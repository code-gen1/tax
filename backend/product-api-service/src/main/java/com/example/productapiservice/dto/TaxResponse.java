package com.example.productapiservice.dto;

public class TaxResponse {
    private double tax;
    public TaxResponse() {}
    public TaxResponse(double tax){this.tax=tax;}
    public double getTax(){return tax;}
    public void setTax(double tax){this.tax = tax;}
}
