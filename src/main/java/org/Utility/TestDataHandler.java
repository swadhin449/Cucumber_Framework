package org.Utility;

import io.cucumber.java.hu.Ha;

import java.util.HashMap;
import java.util.Map;

public class TestDataHandler {
    Map<String,String> testDataInMap = new HashMap<String ,String>();
    public Map<String, String> getTestDataInMap() {
        return testDataInMap;
    }

    public void setTestDataInMap(Map<String, String> testDataInMap) {
        this.testDataInMap = testDataInMap;
    }

}
