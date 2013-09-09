package de.is24.demo.karma;

import de.is24.util.karmatestrunner.junit.KarmaTestSuiteRunner;
import org.junit.runner.RunWith;


@RunWith(KarmaTestSuiteRunner.class)
@KarmaTestSuiteRunner.KarmaConfigPath("./test/javascript/config/karma.conf.js")
//@KarmaTestSuiteRunner.KarmaProcessBuilderArgs("./scripts/test.sh") // i need this when running on mac to get karma to runn
public class JavaScriptUnitTestKarmaSuite {
}
