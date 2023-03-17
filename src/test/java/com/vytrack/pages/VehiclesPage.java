package com.vytrack.pages;

import static com.utilities.BrowserUtil.*;
import com.utilities.Driver;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VehiclesPage extends BasePage{
    public VehiclesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    WebElement setPageLink;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']//following-sibling::ul//a")
    List<WebElement> pageOptions;

    @FindBy(xpath = "//tbody[@class='grid-body']/tr")
    List<WebElement> items;


    public void setPage(int setPage){
        click(setPageLink);
        for (WebElement webElement : pageOptions) {
            try {
                if (webElement.getText().trim().equals(setPage+"")) {
                    webElement.click();
                }
            }catch (StaleElementReferenceException ignored){
            }
        }
    }

    public int getItem(){
        sleep(1);
        return items.size();
    }


    @Override
    protected String getTitle() {
        return getTitle();
    }
}
