package de.is24.demo.karma;

import de.is24.util.karmatestrunner.junit.KarmaTestSuiteRunner;
import org.junit.runner.RunWith;


@RunWith(KarmaTestSuiteRunner.class)
@KarmaTestSuiteRunner.KarmaConfigPath("./test/javascript/config/karma.conf.js")
@KarmaTestSuiteRunner.KarmaRemoteServerPort(9877)
public class JavaScriptUnitTestKarmaSuite {
}
