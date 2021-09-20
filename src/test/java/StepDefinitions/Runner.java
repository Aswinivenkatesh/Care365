package StepDefinitions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/Features",
glue= {"StepDefinitions"},
tags = "@Smoke",
monochrome= true)

public class Runner extends AbstractTestNGCucumberTests {
}
