package com.example.demo.webservice.service;

import com.example.demo.model.base.EmptyRequest;
import com.example.demo.model.base.EmptyResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MockApiService {

    private final RestTemplate restTemplate;

    public MockApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public EmptyResponse getProfileFromWeb(EmptyRequest request){
        return restTemplate.exchange(
          "https://run.mocky.io/v3/59395df1-3538-4ae2-bf2b-2ac42c448085",
                HttpMethod.GET,
                new HttpEntity<>(request),
                EmptyResponse.class
        ).getBody();
    }
}
