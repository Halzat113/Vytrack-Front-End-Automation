package com.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtil {
    public static void sleep(int sec){
        try{
            Thread.sleep(sec * 1000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void click(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void send_key(WebElement element,String key){
        element.sendKeys(key);
    }

    public static void navigateTo(String url){
        Driver.getDriver().get(url);
    }

    public static String getTitle(){
       return Driver.getDriver().getTitle();
    }

    public static void titleTobe(String url){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs(url));
    }

    public static void TitleVerification(String expected){
        titleTobe(expected);
        expected = getTitle();
        Assert.assertEquals(expected,getTitle());
    }

    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void waitUntilTobe(WebElement element,String str){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(element,str));
    }
}
