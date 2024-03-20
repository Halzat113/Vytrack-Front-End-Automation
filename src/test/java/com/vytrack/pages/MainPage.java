package com.vytrack.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage{
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public String getTitle(){
        return "Dashboard";
    }
}
