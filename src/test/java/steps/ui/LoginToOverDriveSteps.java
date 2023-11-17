package steps.ui;

import com.modules.pages.ui.LoginToOverDrivePage;
import cucumber.api.java.en.Given;

public class LoginToOverDriveSteps {
    LoginToOverDrivePage loginToOverDrivePage;

    @Given("^user has launched OverDrive application successfully$")
    public void launchApplication() {
        loginToOverDrivePage.launchApplication();
    }
    
    
}
