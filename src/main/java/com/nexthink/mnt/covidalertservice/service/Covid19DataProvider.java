package com.nexthink.mnt.covidalertservice.service;


import jsonij.Value;
import jsonij.parser.JSONParser;
import jsonij.parser.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Covid19DataProvider {


    String apiUrl = "https://fxs6l35t9e.execute-api.eu-west-3.amazonaws.com/pro/api/2020-12-06/";

    // This will be used to send requests to the api
    @Autowired
    RestTemplate restTemplate;

    public String getCountryAndStateData(String country, String state, String dataField) throws ParserException {
        // Provide a default value for dataField if it was passed as null
        dataField = dataField != null ? dataField : "today_confirmed";
        // Init return value
        Value regionData;
        // Init the Jason parser
        JSONParser parser = new JSONParser();
        // Update URL with selected country and state
        String countryAndStateEndpoint = "country/" + country + "/region/" + state;
        // Finalize Request url
        String requestUrl = apiUrl + countryAndStateEndpoint;
        // Get the API response and store it in a string
        String JsonResponse = restTemplate.getForObject(requestUrl, String.class);
        // ? For debug
        System.out.println("Response from api url is " + JsonResponse);
        // Parse the JsonResponse
        Value jsonBody = parser.parse(JsonResponse);
        // ? For debug
        System.out.println("Data after parsing " + jsonBody);
        // Get region data
        if (dataField.equals("all")) {
            // Provide all received data
            regionData = jsonBody.get("dates").get("2020-12-06").get("countries").get(country).get("regions").get(0);
            // ? For debug
            System.out.println("Returned data is " + regionData);
        } else {
            // Provide specific data
            regionData = jsonBody.get("dates").get("2020-12-06").get("countries").get(country).get("regions").get(0).get(dataField);
            // ? For debug
            System.out.println("Returned data is " + regionData);
        }
        return String.valueOf(regionData);


    }
}
