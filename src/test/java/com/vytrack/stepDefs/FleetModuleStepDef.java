package com.vytrack.stepDefs;

import com.utilities.GlobalData;
import com.vytrack.pages.CommonModulePage;
import com.vytrack.pages.CreationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Map;

public class FleetModuleStepDef {
    CommonModulePage commonModulePage = new CommonModulePage();

    CreationPage creationPage = new CreationPage();
    GlobalData data = new GlobalData();
    @When("I set page to {int}")
    public void i_set_page_to(int pageNum) {
        commonModulePage.setPage(pageNum);
        data.setNum(pageNum);
    }

    @Then("I should get the correct result")
    public void iShouldGetTheCorrectResult() {
        Assert.assertEquals(commonModulePage.getItem(),data.getNum());
    }

    @And("I navigate to {string} page")
    public void iNavigateToPage(String title) {
        commonModulePage.clickCreationButton(title);
    }

    @When("I fill out info")
    public void i_fill_out_info(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> info = dataTable.asMap(String.class,String.class);
        creationPage.fillOutForm(info);
    }


    @Then("I save the data")
    public void iSaveTheData() {
        creationPage.save();
    }
}
