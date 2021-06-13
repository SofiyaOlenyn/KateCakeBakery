package com.university.confectionary.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ReviewsServiceTest {

    @Autowired
    public ReviewsService reviewsService;

    @Test
    public void testGetAllReviews() {
        var reviews = reviewsService.getAllReviews();
        assert reviews != null;

        assertEquals("Tom", reviews.getBody().get(0).getAuthor());
    }

}