package de.is24.demo.karma;

import de.is24.util.karmatestrunner.junit.KarmaTestSuiteRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(KarmaTestSuiteRunner.class)
@KarmaTestSuiteRunner.KarmaProcessName("./node_modules/karma/bin/karma")
@KarmaTestSuiteRunner.KarmaConfigPath("./test/javascript/config/karma-e2e.conf.js")
@KarmaTestSuiteRunner.KarmaRemoteServerPort(9877)
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
