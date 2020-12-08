package com.nexthink.mnt.covidalertservice.service;


import jsonij.Value;
import jsonij.parser.JSONParser;
import jsonij.parser.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Covid19DataProvider {

    // Init logger
    Logger logger = LoggerFactory.getLogger(Covid19DataProvider.class);
    String apiUrl = "https://fxs6l35t9e.execute-api.eu-west-3.amazonaws.com/pro/api/";

    // This will be used to send requests to the api
    @Autowired
    RestTemplate restTemplate;

    public String getCountryAndStateData(String country, String state, String dataField, String date) throws ParserException {

        // Provide a default value for dataField if it was passed as null
        dataField = dataField != null ? dataField : "today_confirmed";
        // Init return value
        Value regionData;
        // Init the Json parser
        JSONParser parser = new JSONParser();
        // Update URL with selected country and state
        String countryAndStateEndpoint = date + "/country/" + country + "/region/" + state;
        // Finalize Request url
        String requestUrl = apiUrl + countryAndStateEndpoint;
        // Get the API response and store it in a string
        String JsonResponse = restTemplate.getForObject(requestUrl, String.class);
        // Debug message
        logger.debug("Response from api url is " + JsonResponse);
        // Assert that the response is not null to avoid problems!
        assert JsonResponse != null;
        // Parse the JsonResponse
        Value jsonBody = parser.parse(JsonResponse);
        // Debug message
        logger.debug("Data after parsing " + jsonBody);
        // Get region data
        if (dataField.equals("all")) {
            // Provide all received data
            regionData = jsonBody.get("dates").get(date).get("countries").get(country).get("regions").get(0);
        } else {
            // Provide specific data
            regionData = jsonBody.get("dates").get(date).get("countries").get(country).get("regions").get(0).get(dataField);
        }
        // Debug message
        logger.debug("Returned data is " + regionData);
        return String.valueOf(regionData);


    }
}
