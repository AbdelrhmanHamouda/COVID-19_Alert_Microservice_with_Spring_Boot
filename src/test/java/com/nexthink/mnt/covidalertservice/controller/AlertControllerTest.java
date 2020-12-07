package com.nexthink.mnt.covidalertservice.controller;

import com.nexthink.mnt.covidalertservice.dto.AlertStatus;
import com.nexthink.mnt.covidalertservice.service.AlertService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlertService alertService;

    @Test
    void getAlertAboutStateTest() throws Exception {

        AlertStatus alertStatus = new AlertStatus();
        alertStatus.setAlertLevel("GREEN");
        // Had to repeat it 3 times to match the number of arguments
        Mockito.when(alertService.getAlertAboutState(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(alertStatus);
        mockMvc.perform(get("/status/Spain/Madrid/2020-08-12"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"alertLevel\":\"GREEN\",\"measuresToBeTaken\":null}"));
    }

}