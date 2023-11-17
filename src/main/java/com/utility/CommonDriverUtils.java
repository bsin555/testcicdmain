/*
 This contains common Utilities which are useful for OverDrive project
 <p>
 Copyright (C) 2017 Clearstream.TV, Inc. All Rights Reserved.
 Proprietary and confidential.
 */

package com.utility;

import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CommonDriverUtils {
    final static Logger SPEAK = LogManager.getLogger(CommonDriverUtils.class);

    /**
     * Following variables need to be removed if fluent wait works
     */
    private static final int MAXTIME_OUT = Integer.parseInt(PropertyFileReader.MAX_TIMEOUT);

    /**
     * This method used to return random alphabet string of specific length
     *
     * @param length, the length of a String to be return
     */
    public static String randomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static boolean waitForElementToBeVisible(WebElement ele) {
        //try {
        Await.setUp().forElementAvailability(ele);
        return true;
        /*} catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE WAITING FOR ELEMENT TO BE VISIBLE : " + ele, e);
            return false;
        }*/
    }

    public static void waitForElementToBeClickable(WebElement ele) {
        try {
            Await.setUp().forElementClickable(ele);
        } catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE WAITING FOR ELEMENT TO BE CLICKABLE : " + ele, e);
        }

    }

    public static void waitForElementTextNotEqualsString(WebElement element, String expectedString, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAXTIME_OUT);
            ExpectedCondition<Boolean> elementTextNotEqualsString = expectedResult -> !(element.getText().equals(expectedString));
            wait.until(elementTextNotEqualsString);
        } catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE WAITING FOR ELEMENT TEXT NOT EQUAL TO GIVEN TEXT : " + element, e);
        }
    }

    public static boolean waitTillElementTextEqualsString(WebElement element, String expectedString, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAXTIME_OUT);
            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedString));
            return true;
        } catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE WAITING TILL ELEMENT TEXT EQUAL TO " + expectedString + " : " + element, e);
            return false;
        }
    }

    public static void waitTillElementTextIsNotEmpty(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAXTIME_OUT);
            ExpectedCondition<Boolean> elementTextEqualsString = expectedResult -> !(element.getText().isEmpty());
            wait.until(elementTextEqualsString);
        } catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE WAITING TILL ELEMENT TEXT IS NOT EMPTY : " + element, e);
        }
    }

    public static void waitForElementValueAttributeToBeNotBlank(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, MAXTIME_OUT);
        ExpectedCondition<Boolean> elementValueAttributeToBeNotBlank = expectedResult -> !(element.getAttribute("value").equals(""));
        wait.until(elementValueAttributeToBeNotBlank);
    }

    public static void waitForListToBeNotEmpty(List<WebElement> element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAXTIME_OUT);
            ExpectedCondition<Boolean> elementValueAttributeToBeNotBlank = expectedResult -> !element.isEmpty();
            wait.until(elementValueAttributeToBeNotBlank);
        } catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE WAITING FOR LIST TO BE NOT EMPTY : " + element, e);
        }
    }

    public static boolean waitForElementToBeVisibleAndClick(WebElement ele) {
        //try {
        waitForElementToBeVisible(ele);
        JSExecutor.CLICK.execute(ele);
        return true;
        /*} catch (Exception e){
            SPEAK.error("EXCEPTION OCCURRED WHILE WAITING FOR ELEMENT TO BE VISIBLE AND CLICK : " + ele, e);
            return false;
        }*/
    }

    public static void waitForElementToBeVisible(WebDriver driver, String ele) {
        WebDriverWait wait = new WebDriverWait(driver, MAXTIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
    }

    public static void waitForListOfElementsToBeVisible(List<WebElement> ele) {
        try {
            Await.setUp().forElementsAvailability(ele);
        } catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE WAITING FOR LIST OF ELEMENT TO BE VISIBLE : " + ele, e);
        }
    }

    public static boolean getElementAndCheckVisibility(String locator, String text, WebDriver driver) {
        try {
            driver.findElement(By.xpath(String.format(locator, text))).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean getElementAndCheckVisibility(String locator, int num, WebDriver driver) {
        try {
            driver.findElement(By.xpath(String.format(locator, num))).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void getElementAndCheckAttributeVisibility(WebElement element, String attribute, String expectedString, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAXTIME_OUT);
            wait.until(ExpectedConditions.attributeContains(element, attribute, expectedString));
        } catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE GETTING ELEMENT AND CHECK ATTRIBUTE VISIBILITY : " + element, e);
        }
    }

    public static boolean waitAndCheckElementVisibility(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAXTIME_OUT);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean elementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static WebElement getElementByMatcherText(String matcherText, WebDriver driver) {
        return driver.findElement(By.xpath(String.format("(//*[contains(text(),'%s')])[1]", matcherText)));
    }

    public static WebElement getElementByText(String locator, String text, WebDriver driver) {
        return driver.findElement(By.xpath(String.format(locator, text)));
    }

    public static List<WebElement> getElementsByText(String locator, String text, WebDriver driver) {
        return driver.findElements(By.xpath(String.format(locator, text)));
    }


    public static WebElement getElementByText(String locator, int value, WebDriver driver) {
        return driver.findElement(By.xpath(String.format(locator, value)));
    }

    public static void clearAndEnterData(WebElement element, String data) {
        Actions actions = new Actions(ThucydidesWebDriverSupport.getDriver());
        //Used blank sendkeys for focusing on given element to perform keystroke on it
        element.sendKeys(PropertyFileReader.BLANK_VALUE);
        actions.keyDown(Keys.CONTROL).sendKeys("a", Keys.DELETE).keyUp(Keys.CONTROL).build().perform();
        element.sendKeys(data);
    }

    public static void waitForElementAndEnterData(WebElement element, String data) {
        waitForElementToBeVisible(element);
        Actions actions = new Actions(ThucydidesWebDriverSupport.getDriver());
        //Used blank sendkeys for focusing on given element to perform keystroke on it
        element.sendKeys(PropertyFileReader.BLANK_VALUE);
        actions.keyDown(Keys.CONTROL).sendKeys("a", Keys.DELETE).keyUp(Keys.CONTROL).build().perform();
        element.sendKeys(data);
    }

    public static void waitForElementAndClearData(WebElement element) {
        waitForElementToBeVisible(element);
        Actions actions = new Actions(ThucydidesWebDriverSupport.getDriver());
        //Used blank sendkeys for focusing on given element to perform keystroke on it
        element.sendKeys(PropertyFileReader.BLANK_VALUE);
        actions.keyDown(Keys.CONTROL).sendKeys("a", Keys.DELETE).keyUp(Keys.CONTROL).build().perform();
    }

    public static void waitForElementToBeClickableAndEnterData(WebElement element, String data) {
        waitForElementToBeClickable(element);
        Actions actions = new Actions(ThucydidesWebDriverSupport.getDriver());
        //Used blank sendkeys for focusing on given element to perform keystroke on it
        element.sendKeys(PropertyFileReader.BLANK_VALUE);
        actions.keyDown(Keys.CONTROL).sendKeys("a", Keys.DELETE).keyUp(Keys.CONTROL).build().perform();
        element.sendKeys(data);
    }

    /**
     * This method is used to wait for given element and fetch text without any space
     *
     * @param ele, The name of the WebElement
     * @return the element text after trim
     */
    public static String waitForElementVisibilityAndGetText(WebElement ele) {
        waitForElementToBeVisible(ele);
        return ele.getText().trim();
    }

    /**
     * This method is used to move on given any element using Selenium Actions
     *
     * @param driver,  The name of the WebDriver
     * @param element, The name of the WebElement
     */
    public static void moveToElement(WebDriver driver, WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        } catch (Exception e) {
            SPEAK.error("EXCEPTION OCCURRED WHILE MOVING TO ELEMENT : " + element, e);
        }
    }

    /**
     * This method used to return Positive or Negative random numeric string of
     * specific length
     *
     * @param length,     the length of a String to be return
     * @param isPositive, the negative or positive flag to be return
     * @return the number value by given params in String format
     */
    public static String randomInteger(int length, boolean isPositive) {
        return isPositive ? RandomStringUtils.random(length, PropertyFileReader.RANDOM_STRING_SEED_VALUE)
                : "-" + RandomStringUtils.random(length, PropertyFileReader.RANDOM_STRING_SEED_VALUE);
    }

    /**
     * This method used to return random double string of specific length
     *
     * @param length,             the length of a String to be return
     * @param lengthAfterDecimal, the length of number after decimal point
     * @return the double value by given params in String format
     */
    public static String randomDouble(int length, int lengthAfterDecimal) {
        return RandomStringUtils.randomNumeric(length) + "." + randomInteger(lengthAfterDecimal, true);
    }

    /**
     * This method used to return random number between given range.
     * Min and Max value are exclusive.
     *
     * @param min, The min value of range
     * @param max, The max value of range
     * @return The number between given range in String format
     */
    public static String randomNumberBetweenRange(int min, int max) {
        return Integer.toString(ThreadLocalRandom.current().nextInt(min + 1, max));
    }
}