package com.nexthink.mnt.covidalertservice.service;

import com.nexthink.mnt.covidalertservice.dto.AlertStatus;
import jsonij.parser.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlertService {

    @Autowired
    private Covid19DataProvider covid19DataProvider;

    public AlertStatus getAlertAboutState(String country, String state) throws ParserException {
        // Create an alertStatus object
        AlertStatus alertStatus = new AlertStatus();

        // Get the country & state data
        String neededData = covid19DataProvider.getCountryAndStateData(country, state, "today_new_confirmed");

        if (Integer.parseInt(neededData) < 1000) {
            alertStatus.setAlertLevel("GREEN");
            alertStatus.setMeasuresToBeTaken(Arrays.asList("No measures needed, all is good."));
        } else if (Integer.parseInt(neededData) > 1000 && Integer.parseInt(neededData) < 2000) {
            alertStatus.setAlertLevel("ORANGE");
            alertStatus.setMeasuresToBeTaken(Arrays.asList("Have your masks and don't go out much!"));
        } else {
            alertStatus.setAlertLevel("RED");
            alertStatus.setMeasuresToBeTaken(Arrays.asList("Stay home and wait for help!!"));
        }

        return alertStatus;
    }
}
