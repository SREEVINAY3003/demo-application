package com.sample.demoapplication.controller;

import com.sample.demoapplication.model.PostResponse;
import com.sample.demoapplication.model.TallyUserIds;
import com.sample.demoapplication.service.SampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class SampleController {

    private SampleService service;

    public SampleController(SampleService service) {
        this.service = service;
    }


    ///Count endpoint which return the number of unique with their response
    @GetMapping(path = "posts")
    public ResponseEntity<List<TallyUserIds>> getUniqueUserId() {

        return ResponseEntity.status(HttpStatus.OK).body(service.getUniqueUserIDWithResponse());
    }

    @PutMapping(path = "post")
    public ResponseEntity<List<PostResponse>> update() {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.update());
    }


}
