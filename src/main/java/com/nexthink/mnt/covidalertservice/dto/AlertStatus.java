package com.nexthink.mnt.covidalertservice.dto;

import java.util.List;

public class AlertStatus {


    String alertLevel; // GREEN, ORANGE, RED

    List<String> measuresToBeTaken;

    public String getAlertLevel(){
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel){
        this.alertLevel = alertLevel;
    }

    public List<String> getMeasuresToBeTaken() {
        return measuresToBeTaken;
    }

    public void setMeasuresToBeTaken(List<String> measuresToBeTaken) {
        this.measuresToBeTaken = measuresToBeTaken;

    }
}
