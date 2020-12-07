package com.nexthink.mnt.covidalertservice.controller;

/*
 * @author - AbdelrhmanHamouda
 */

import com.nexthink.mnt.covidalertservice.service.AlertService;
import com.nexthink.mnt.covidalertservice.dto.AlertStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    // @Autowired allows Spring to resolve and inject collaborating beans into our bean
    // [ahamouda] To my understanding this means that the framework will inject that dependency and manage it!
    @Autowired
    private AlertService alertService;

    @GetMapping("/status/{country}/{state}")
    AlertStatus getAlertAboutState(@PathVariable String country, @PathVariable String state) {
        // Passing the call to the service because no business logic should be down inside the controller.
        return alertService.getAlertAboutState(country, state);
    }
}
