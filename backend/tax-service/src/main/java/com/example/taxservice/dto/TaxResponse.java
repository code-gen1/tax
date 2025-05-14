package com.example.taxservice.dto;

public class TaxResponse {
    private double tax;
    public TaxResponse(double tax){this.tax = tax;}
    public double getTax(){return tax;}
    public void setTax(double tax){this.tax = tax;}
}
