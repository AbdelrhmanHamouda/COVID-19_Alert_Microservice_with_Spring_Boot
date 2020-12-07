package com.nexthink.mnt.covidalertservice.service;


import com.nexthink.mnt.covidalertservice.dto.CountryAndStateData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Covid19DataProvider {

    // TODO: The url should be modified with country and state provided
    final String url = "https://fxs6l35t9e.execute-api.eu-west-3.amazonaws.com/pro/api/2020-12-06/country/spain/region/madrid";

    RestTemplate restTemplate;
    CountryAndStateData getCountryAndStateData(String country, String state) {

    }
}
