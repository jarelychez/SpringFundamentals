package com.example.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//  TODO-03:  Refactor this test class to use Spring's test framework.

@SpringJUnitConfig(Config.class)
@ActiveProfiles("compound")
public class RegisterCompoundTest {

    @Autowired Register register;

    @Test 
    void testRegister() {
        double result = register.computeTotal(100);
        Assertions.assertThat(result).isEqualTo(100.00 + 8.50);
        // Assertions.assertThat(result).isEqualTo(100.00 + 7.0);
        System.out.println(String.format("The computed total including tax is: %.2f", result));
    }


//  TODO-04:  (OPTIONAL) Without modifying app.properties, change the 
//  tax.rate and local.tax.rate properties used by this test to 0.03 and 0.04 respectively.
//  Modify the code in the testRegister() method to expect a result of 100.00 + 7.
//  Run the test.  It should pass.


}
