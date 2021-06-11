package com.university.confectionary.service;

import com.university.confectionary.domain.entities.ReviewEntity;
import com.university.confectionary.dto.ReviewDto;
import com.university.confectionary.repositories.ReviewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Transactional
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        var reviews = reviewsRepository.findAll();
        var reviewsDtoList = new ArrayList<ReviewDto>();
        for (ReviewEntity review: reviews) {
            reviewsDtoList.add(new ReviewDto(review.getText(), review.getAuthor(), review.getId()));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, "generated-jwt-token")
                .body((reviewsDtoList));
    }
}

