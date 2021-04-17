package com.sample.demoapplication.service;

import com.sample.demoapplication.model.PostResponse;
import com.sample.demoapplication.model.TallyUserIds;

import java.util.List;

public interface SampleService {

    List<TallyUserIds> getUniqueUserIDWithResponse();

    List<PostResponse> update();
}
