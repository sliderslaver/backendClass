package com.example.Simone.service;

import com.example.Simone.client.UserDetailClient;
import com.example.Simone.database.UserDatabase;
import com.example.Simone.model.User;
import com.example.Simone.model.Users;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDatabase userDatabase;

    @Mock
    private UserDetailClient userDetailClient;

    @InjectMocks
    private UserService userService;

    @Test
    void retrieveUser() {
        when(userDatabase.retrieveUserName()).thenReturn(List.of("Pippo", "Paperino"));
        val out = userService.retrieveUser("Pippo");
        assertEquals("Pippo", out);
    }

    @Test
    void retrieveUserWithNoMatching() {
        when(userDatabase.retrieveUserName()).thenReturn(List.of("Paperino"));
        val out = userService.retrieveUser("Pippo");
        assertEquals("No Match", out);
    }

    @Test
    void retrieveUsersDetails() {
        val user = User.builder()
                .firstName("Simone")
                .age(18)
                .id(1)
                .build();

        val users = Users.builder()
                .users(List.of(user))
                .limit(100)
                .total(100)
                .skip(100)
                .build();

        when(userDetailClient.retrieveUserDetails()).thenReturn(users);
        val out = userService.retrieveUsersDetails();
        assertEquals(100, out.getLimit());
        assertNotNull(out.getUsers());
        val userOutput = out.getUsers();
        assertEquals("Simone",userOutput.get(0).getFirstName());
    }

    @Test
    void retrieveUsersDetailsFilteredByAge() {
    }
}