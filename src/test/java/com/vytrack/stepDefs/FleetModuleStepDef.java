package com.vytrack.stepDefs;

import com.utilities.GlobalData;
import com.vytrack.pages.VehiclesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FleetModuleStepDef {
    VehiclesPage vehiclesPage = new VehiclesPage();
    GlobalData data = new GlobalData();
    @When("I set page to {int}")
    public void i_set_page_to(int pageNum) {
        vehiclesPage.setPage(pageNum);
        data.setNum(pageNum);
    }

    @Then("I should get the correct result")
    public void iShouldGetTheCorrectResult() {
        Assert.assertEquals(vehiclesPage.getItem(),data.getNum());
    }
}
