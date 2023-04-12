package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.utilities.BrowserUtil.*;

import java.util.List;

public abstract class BasePage{
    @FindBy(xpath = "//li[@id='user-menu']/a")
    protected WebElement userMenu;

    @FindBy(xpath = "//ul[@role='menu']/li/a")
    protected List<WebElement> userDropDown;

    @FindBy(xpath = "//ul[@class='nav-multilevel main-menu']/li/a")
    protected List<WebElement> mainMenu;

    @FindBy(xpath = "//ul[@class='nav-multilevel main-menu']/li//li[contains(@class,'single')]/a")
    protected List<WebElement> options;

    public void clickOn(String option, String menu){
        if (menu.contains("user")){
            click(userMenu);
           selectOption(userDropDown,option);
        } else if(menu.contains("fleet")){
            for (WebElement webElement : mainMenu) {
                if (menu.contains(webElement.getText().toLowerCase())){
                    hover(webElement);
                    sleep(1);
                }
            }
           selectOption(options,option);
        }
    }

    public void selectOption(List<WebElement> elements,String option){
        for (WebElement webElement : elements) {
            if (webElement.getText().trim().equalsIgnoreCase(option)){
                click(webElement);
            }
        }
    }



    protected abstract String getTitle();

}
