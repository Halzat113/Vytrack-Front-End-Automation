package com.vytrack.stepDefs;

import com.utilities.Environment;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.MainPage;
import io.cucumber.java.en.*;
import static com.utilities.BrowserUtil.*;
import org.junit.Assert;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    @Given("I am on the {string} page")
    public void i_am_on_the_page(String page) {

       if (page.equals("login")){
           TitleVerification(loginPage.getTitle());
       } else if (page.equals("main")) {
           TitleVerification(mainPage.getTitle());
       }
    }
    @When("I enter {string} datatype as {string}")
    public void i_enter_datatype_as(String dataType,String as) {
        loginPage.login(dataType,as);
    }

    @When("I login as {string}")
    public void iLoginAs(String user) {
        loginPage.login(user);
    }

    @When("I click on {string}")
    public void iClickOn(String textName) {
       mainPage.clickOn(textName);
        sleep(2);
    }


}
