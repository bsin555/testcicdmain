/*
 Common Utility for waiting on action
 */

package com.utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Await {
    static FluentWait<WebDriver> fluent_wait;
    static int mx_timeout = Integer.parseInt(PropertyFileReader.MAX_TIMEOUT);
    static int polling_frq = 10;

    public static Await setUp() {
        fluent_wait = new FluentWait<>(getDriver());
        fluent_wait.withTimeout(Duration.ofSeconds(mx_timeout))
                .pollingEvery(Duration.ofSeconds(polling_frq))
                .ignoring(NoSuchElementException.class);
        return new Await();
    }

    public static Await setUp(int max_timeout) throws Exception {
        fluent_wait = new FluentWait<>(getDriver());
        fluent_wait.withTimeout(Duration.ofSeconds(max_timeout))
                .pollingEvery(Duration.ofSeconds(polling_frq))
                .ignoring(NoSuchElementException.class);
        return new Await();
    }

    public void forElementAvailability(WebElement element_to_wait_for)  {
        fluent_wait.until(ExpectedConditions.visibilityOf(element_to_wait_for));
        fluent_wait.until(driver -> element_to_wait_for);
    }

    public void forElementsAvailability(List<WebElement> elements_to_wait_for) {
        fluent_wait.until(ExpectedConditions.visibilityOfAllElements(elements_to_wait_for));
    }

    public void forElementClickable(WebElement element_to_wait_for) {
        fluent_wait.until(ExpectedConditions.elementToBeClickable(element_to_wait_for));
        fluent_wait.until(driver -> element_to_wait_for);
    }
}