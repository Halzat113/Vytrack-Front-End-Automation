package com.utilities;

import io.cucumber.java.Scenario;

public class GlobalData {
    private String scenarioName;

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setScenarioName(String scenarioName){
        this.scenarioName = scenarioName;
    }

    public String getScenarioName(){
        return scenarioName;
    }
}
