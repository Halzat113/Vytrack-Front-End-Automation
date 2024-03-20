package com.vytrack.pages;

import com.utilities.Driver;
import static com.utilities.BrowserUtil.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class CreationPage {

    public CreationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected String keyXpath = "//label[contains(text(),'%s')]/../following-sibling::div/input";
    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    protected WebElement saveButton;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    protected WebElement cancelButton;

    @FindBy(xpath = "//span[@class='validation-failed']")
    protected WebElement errorMsg;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    protected WebElement year;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    protected WebElement month;

    @FindBy(xpath = "//a[@class='ui-state-default']")
    List<WebElement>dayList;

    public void fillOutForm(Map<String, String> info) {
        String key;
        for (String s : info.keySet()) {

            if (s.contains(" ")) {
                key = StringUtils.capitalize(s.split(" ")[0]);
            } else {
                key = StringUtils.capitalize(s);
            }

            if (s.equals("date")){
                click(findByXpath(keyXpath,key));
                datePicker(info.get(s));
                continue;
            }
            WebElement input = findByXpath(keyXpath, key);
            input.sendKeys(info.get(s));
            try {
                implicitWaitOff();
                Assert.assertFalse(errorMsg.isDisplayed());

            }catch (Exception ignored){
                implicitWaitOn();
            }
        }
    }

    public void datePicker(String date){
        Select yearSelect = new Select(year);
        Select montSelect = new Select(month);
        String[] dateArr = date.split("-");
        yearSelect.selectByValue(dateArr[0]);
        montSelect.selectByVisibleText(dateArr[1]);
        for (WebElement s : dayList) {
            if (s.getText().equals(dateArr[2])){
                s.click();
            }
        }
    }

    public void save(){
        click(saveButton);
    }


}

