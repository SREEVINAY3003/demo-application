package com.sample.demoapplication.integration;

import com.sample.demoapplication.model.PostResponse;

import java.util.List;

public interface PostDataClient {

    List<PostResponse> getAllPosts();

}
