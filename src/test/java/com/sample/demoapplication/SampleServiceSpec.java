package com.sample.demoapplication;

import com.sample.demoapplication.integration.PostDataClient;
import com.sample.demoapplication.model.PostResponse;
import com.sample.demoapplication.model.TallyUserIds;
import com.sample.demoapplication.service.SampleService;
import com.sample.demoapplication.service.impl.SampleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class SampleServiceSpec {

    @Test
    public void getUniqueUserIdTest() {

        PostDataClient clientMock = mock(PostDataClient.class);

        when(clientMock.getAllPosts()).thenReturn(Arrays.asList(new PostResponse(1, 1, "sunt aut facere repellat provident",
                "quia et suscipit"), new PostResponse(1, 2, "sunt aut facere repellat provident",
                "quia et suscipit")));

        SampleService business = new SampleServiceImpl(clientMock);

        List<TallyUserIds> response = business.getUniqueUserIDWithResponse();
        assert response.size() == 1;

    }

}