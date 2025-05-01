package com.example.demo.adaptor.service;

import com.example.demo.model.base.EmptyRequest;
import com.example.demo.adaptor.model.MockApiResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MockApiAdaptor {

    private final RestTemplate restTemplate;

    public MockApiAdaptor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MockApiResponse getProfileFromWeb(EmptyRequest request){
        return restTemplate.exchange(
          "https://run.mocky.io/v3/59395df1-3538-4ae2-bf2b-2ac42c448085",
                HttpMethod.GET,
                new HttpEntity<>(request),
                MockApiResponse.class
        ).getBody();
    }
}
