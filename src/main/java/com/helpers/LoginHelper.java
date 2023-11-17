package com.helpers;

import com.utility.PropertyFileReader;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class LoginHelper extends PageObject {
    //start launchApplication

    /**
     * It will check if current url is of qa-overdrive application,
     * then it will logs out of the application,
     * if not, then it will launch the qa-overdrive application and will maximize the window.
     */
    @Step
    public void launchApplication() {
        getDriver().get(PropertyFileReader.APP_URL);
        getDriver().manage().window().maximize();
    }
    //end region
}
