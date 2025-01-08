package org.Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;

import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/features/HomePage.feature",
        glue = {"org.StepDef"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,
        tags = "@HomePage",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(dataProvider="features")
    public void feature(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
    @DataProvider(name = "features") // Ensure the DataProvider is named 'features'
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        if (testNGCucumberRunner != null) {
            testNGCucumberRunner.finish();
        }
    }
}
