package com.orangehrm.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        features = "src/test/resources/features/",
        glue = "com.orangehrm.stepdefinitions",
        tags = "@all",
        plugin = {"pretty", "html:target/cucumber-reports.html"}

        )

public class OrangeRunners {
}
