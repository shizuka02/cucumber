package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Shalini.Verma\\Cucumber\\src\\test\\resources\\Features",
        glue={"Testdefinition"})
public class TestRunner {
}
