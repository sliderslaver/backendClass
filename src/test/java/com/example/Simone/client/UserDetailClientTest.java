package com.example.Simone.client;

import com.example.Simone.exception.UserGenericErrorException;
import com.example.Simone.model.Users;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserDetailClient userDetailClient;

    @Test
    void retrieveUserDetails() {
        val users = Users.builder().limit(100000).build();
        when(restTemplate.getForObject(anyString(), any())).thenReturn(users);
        val out = userDetailClient.retrieveUserDetails();
        assertEquals(users, out);
    }

    @Test
    void retrieveUserDetailsThrowingException() {
        when(restTemplate.getForObject(anyString(), any())).thenThrow(new RuntimeException());
        assertThrows(UserGenericErrorException.class, () -> userDetailClient.retrieveUserDetails());
    }
}