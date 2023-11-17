package com.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public enum JSExecutor {
    CLICK("arguments[0].click();"),
    SCROLL_TO_ELEMENT("arguments[0].scrollIntoView(true);"),
    REFRESH_BROWSER("location.reload()"),
    OPEN_NEW_TAB("window.open('about:blank','_blank');"),
    BY_PROP_PAGE_DOWN(PropertyFileReader.PAGE_DOWN_SCRIPT);

    public String execute_statement;
    JavascriptExecutor js;

    JSExecutor(String execute_statement) {
        this.js = (JavascriptExecutor) getDriver();
        this.execute_statement = execute_statement;
    }

    public void execute() {
        this.js.executeScript(this.execute_statement);
    }

    public void execute(WebElement element_as_arg) {
        this.js.executeScript(this.execute_statement, element_as_arg);
    }
}
