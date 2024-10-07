package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features= {".//features/login1.feature"},
                 glue={"stepdefinitions","hooks"},
                 plugin= {"pretty","html:reports/myreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 monochrome=true,
                 publish=true)
@RunWith(Cucumber.class)
public class TestRunner {

}
