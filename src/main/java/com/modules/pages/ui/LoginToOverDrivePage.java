package com.modules.pages.ui;

import com.helpers.LoginHelper;
import net.thucydides.core.annotations.Step;

/**
 * Purpose of this is to verify Login functionality of OverDrive Application.
 * It contains all the web elements & methods to support the above cause.
 */

public class LoginToOverDrivePage extends LoginHelper {
    LoginHelper loginHelper = new LoginHelper();

    //start launchApplication

    /**
     * It will launch the qa-overdrive application
     */
    @Step
    public void launchApplication() {
        loginHelper.launchApplication();
    }
    //end region
}