package com.vytrack.pages;

import static com.utilities.BrowserUtil.*;
import com.utilities.Driver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonModulePage extends BasePage{
    public CommonModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    protected String creationXpath = "//a[@title='Create Vehicle %s']";

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    protected WebElement setPageLink;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']//following-sibling::ul//a")
    protected List<WebElement> pageOptions;

    @FindBy(xpath = "//tbody[@class='grid-body']/tr")
    protected List<WebElement> items;


    public void clickCreationButton(String title){
        String moduleName = StringUtils.capitalize(title.split(" ")[0]);
        WebElement creationButton = findByXpath(creationXpath,moduleName);
        click(creationButton);
    }
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
