package de.is24.demo.karma;

import de.is24.util.karmatestrunner.junit.KarmaTestSuiteRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(KarmaTestSuiteRunner.class)
@KarmaTestSuiteRunner.KarmaConfigPath("./src/test/resources/config/karma-e2e.conf.js")
@KarmaTestSuiteRunner.KarmaProcessBuilderArgs("./scripts/e2e-test.sh") // i need this when running on mac to get karma to run
public class JavaScriptE2eTestKarmaSuite {

    @BeforeClass
    public static void setup(){
        // setup your test scenario
    }

    @AfterClass
    public static void teardown(){
        // cleanup your test scenario
    }
}
