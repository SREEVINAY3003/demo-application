package com.sample.demoapplication.integration.impl;

import com.sample.demoapplication.integration.PostDataClient;
import com.sample.demoapplication.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PostDataClientImpl implements PostDataClient {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<PostResponse> getAllPosts() {

        return restTemplate.exchange("http://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<PostResponse>>() {
                }).getBody();
    }

}
