/*
 This helps to run OverDrive project
 <p>
 Copyright (C) 2017 Clearstream.TV, Inc. All Rights Reserved.
 Proprietary and confidential.
 */
package steps.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/ui/user-management/", glue = {"steps"}, plugin = {"json:target/cucumber-report/cucumber.json"})
public class TestRunner {

}
