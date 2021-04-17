package com.sample.demoapplication.service.impl;


import com.sample.demoapplication.integration.PostDataClient;
import com.sample.demoapplication.model.PostResponse;
import com.sample.demoapplication.model.TallyUserIds;
import com.sample.demoapplication.service.SampleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SampleServiceImpl implements SampleService {

    private PostDataClient postDataClient;

    public SampleServiceImpl(PostDataClient postDataClient) {
        this.postDataClient = postDataClient;
    }


    @Override
    public List<TallyUserIds> getUniqueUserIDWithResponse() {
        List<TallyUserIds> tallyUserIds = new ArrayList<>();
        List<PostResponse> allPosts = postDataClient.getAllPosts();

        Map<Integer, List<PostResponse>> val = allPosts.stream()
                .collect(Collectors.groupingBy(PostResponse::getUserId));
        val.forEach((key, value) -> tallyUserIds.add(new TallyUserIds(key, value.size())));
        return tallyUserIds;

    }

    @Override
    public List<PostResponse> update() {
        List<PostResponse> allPosts = postDataClient.getAllPosts();
        PostResponse postResponse = allPosts.get(3);
        postResponse.setBody("1800Flowers");
        postResponse.setTitle("1800Flowers");
        allPosts.set(3, postResponse);
        return allPosts;
    }
}
