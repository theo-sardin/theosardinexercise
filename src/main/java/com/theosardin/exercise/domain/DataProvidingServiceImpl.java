package com.theosardin.exercise.domain;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataProvidingServiceImpl implements DataProvidingService {

    @Override
    public String getData() {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        String url = "https://jsonplaceholder.typicode.com/404";
        return restTemplate.getForObject(url, String.class);
    }
}
