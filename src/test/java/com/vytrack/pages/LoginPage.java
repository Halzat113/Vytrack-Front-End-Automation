package com.vytrack.pages;

import com.utilities.Driver;
import com.utilities.Environment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.utilities.BrowserUtil.*;
import static com.utilities.DataUtil.*;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "prependedInput" )
    protected WebElement userInput;

    @FindBy(id = "prependedInput2")
    protected WebElement passwordInput;

    @FindBy(id = "remember_me")
    protected WebElement rememberMeCheckbox;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    protected WebElement resetPasswordLink;

    @FindBy(id = "_submit")
    protected WebElement submitButton;

    public void fillUpInput(String inputName,String key){
        if (inputName.equalsIgnoreCase("username")){
            send_key(userInput,key);
        }else if (inputName.equalsIgnoreCase("password")){
            send_key(passwordInput,key);
        } else {
            throw new RuntimeException("Unexpected input(s)");
        }
    }

    public void checkBoxClick(){
        click(rememberMeCheckbox);
    }

    public void clickPasswordResetLink(){
        click(resetPasswordLink);
    }

    public void login(String dataType,String as){
        if (dataType.equalsIgnoreCase("positive")){
            fillUpInput("username", Environment.getProperty(as+"_username"));
            fillUpInput("password", decrypt(Environment.getProperty("password")));
            click(submitButton);
        } else if (dataType.equalsIgnoreCase("negative")) {
            fillUpInput("username",Environment.getProperty("badUsername"));
            fillUpInput("password",Environment.getProperty("badPassword"));
            click(submitButton);
        }else {
            throw new RuntimeException("Unexpected input");
        }
    }

    public void login(String user){
        login("positive",user);
    }

    public String getTitle(){return "Login";}



}
