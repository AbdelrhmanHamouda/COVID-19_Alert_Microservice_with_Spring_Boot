package com.nexthink.mnt.covidalertservice.controller;

/*
 * @author - AbdelrhmanHamouda
 */

import com.nexthink.mnt.covidalertservice.service.AlertService;
import com.nexthink.mnt.covidalertservice.dto.AlertStatus;
import jsonij.parser.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status/")
public class AlertController {
    // Init logger
    Logger logger = LoggerFactory.getLogger(AlertController.class);
    // @Autowired allows Spring to resolve and inject collaborating beans into our bean
    // [ahamouda] To my understanding this means that the framework will inject that dependency and manage it!
    @Autowired
    private AlertService alertService;

    @GetMapping("/{country}/{state}/{date}")
    AlertStatus getAlertAboutState(@PathVariable String country, @PathVariable String state, @PathVariable String date) throws ParserException {
        // Passing the call to the service because no business logic should be down inside the controller.
        return alertService.getAlertAboutState(country, state, date);
    }
}
