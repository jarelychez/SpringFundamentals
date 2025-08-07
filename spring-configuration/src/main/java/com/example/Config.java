package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.Register;
import com.example.service.SalesTaxCalculator;
import com.example.service.TaxCalculator;

//  TODO-01: Add an annotation to mark this class as a Configuration class:
@Configuration
public class Config {

    //  TODO-02: Write a method to define a Spring Bean.
    @Bean
    public SalesTaxCalculator salesTaxCalculatorBean() {
        return new SalesTaxCalculator();
    }

    
    //  TODO-03: Write a method to define a Spring Bean.
    @Bean
    public Register registerBean(TaxCalculator newTaxCalculator) {
        return new Register(newTaxCalculator);
    }

    //  TODO-04: Organize your imports.  Save your work.
}
