package com.vytrack.pages;

import com.utilities.Driver;
import com.utilities.Environment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.utilities.BrowserUtil.*;
import static com.utilities.JsonReader.*;
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

    /**
     *
     * @param dataType positive, negative
     * @param as driver, storemanager, salesmanager
     */
    public void login(String dataType,String as){
        String username = getSingleString(as,"username",dataType);
        String password = decrypt(getSingleString(as,"password",dataType));
        fillUpInput("username",username);
        fillUpInput("password",password);
        click(submitButton);
    }

    /**
     *
     * @param as, storemanager, salesmanager
     */
    public void login(String as){
        login("positive",as);
    }

    public String getTitle(){return "Login";}



}
