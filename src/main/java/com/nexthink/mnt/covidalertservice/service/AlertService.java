package com.nexthink.mnt.covidalertservice.service;

import com.nexthink.mnt.covidalertservice.dto.AlertStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlertService {

    @Autowired
    private Covid19DataProvider covid19DataProvider;

    public AlertStatus getAlertAboutState(String country, String state) {
        // Create an alertStatus object
        AlertStatus alertStatus = new AlertStatus();

        alertStatus.setAlertLevel("GREEN");
        alertStatus.setMeasuresToBeTaken(Arrays.asList("No measures needed, all is good."));

        return alertStatus;
    }
}
