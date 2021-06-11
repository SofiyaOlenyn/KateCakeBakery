package com.university.confectionary.controller;

import com.university.confectionary.dto.ReviewDto;
import com.university.confectionary.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewsController {
    private final ReviewsService reviewService;

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public ResponseEntity<List<ReviewDto>> reviews() {
        return reviewService.getAllReviews();
    }

}

