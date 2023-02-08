package com.vytrack.pages;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.utilities.BrowserUtil.*;

import java.util.List;

public abstract class BasePage {
    @FindBy(xpath = "//li[@id='user-menu']/a")
    protected WebElement userMenu;

    @FindBy(xpath = "//ul[@role='menu']/li/a")
    protected List<WebElement> userDropDown;

    public void clickOn(String linkName){
        click(userMenu);
        for (WebElement webElement : userDropDown) {
            if (webElement.getText().equalsIgnoreCase(linkName)) {
                webElement.click();
            }
        }
    }

    protected abstract String getTitle();

}
