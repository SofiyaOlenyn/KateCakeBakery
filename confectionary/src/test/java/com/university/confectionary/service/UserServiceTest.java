/*package com.university.confectionary.service;

import com.university.confectionary.domain.entities.UserEntity;
import com.university.confectionary.repositories.UserRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class )
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    //@Autowired
    @InjectMocks
    public UserService userService = new UserService(userRepository);;

    @Before
    public void setUp(){

        userService = new UserService(userRepository);
       // orderService = new OrderService(productRepository,orderRepository);
        // reviewsService = new ReviewsService(reviewsRepository);
        // MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testCreateUser() {
        UserEntity user = new UserEntity(0,"df","dds",eq("GDFSD"),new ArrayList<>());

      //  given(userRepository.save(user)).willAnswer(invocation -> invocation.getArguments()[0]);

        when(userRepository.findByLogin(anyString())).thenReturn(java.util.Optional.of(user));
       // when(userRepository.save(user)).thenReturn(user);
       Boolean newUser = userService.createUser(anyString(),anyString());

        verify(userRepository.saveAndFlush(user));
       // assertTrue(userService.createUser("df","dds"));
       // verify(userRepository).save(UserEntity.class);
    }
}*/