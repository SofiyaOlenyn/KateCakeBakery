package com.university.confectionary.service;


import com.university.confectionary.domain.entities.ReviewEntity;
import com.university.confectionary.repositories.ReviewsRepository;
import junit.framework.TestCase;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class )
public class ReviewsServiceTest {


    public ReviewsService reviewsService;

    @Mock
    private ReviewsRepository reviewsRepository;


    @Before
    public void setUp(){
        reviewsService = new ReviewsService(reviewsRepository);
    }

    @Test
    public void testGetAllReviews() {


        ReviewEntity r1 = new ReviewEntity(1,"Tomiirerf", "Tom");
        ReviewEntity r2 = new ReviewEntity(2,"Aaaaaaa", "ALice");
        List<ReviewEntity> reviews = Arrays.asList(r1,r2);

        when(reviewsRepository.findAll()).thenReturn(reviews);


        var result = reviewsService.getAllReviews();
        assert result != null;

        assertEquals("Tom", result.getBody().get(0).getAuthor());
    }

}