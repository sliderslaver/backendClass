package com.example.Simone.client;

import com.example.Simone.exception.UserGenericErrorException;
import com.example.Simone.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserDetailClient {

    private static final String URL = "https://dummyjson.com/users?limit=5&select=firstName,age";

    private final RestTemplate restTemplate;

    public Users retrieveUserDetails() {
        try {
            return restTemplate.getForObject(URL, Users.class);
        } catch (Exception e){
            throw new UserGenericErrorException("Si è verificato un errore durante il ritrovo dei dettagli dell'utente");
        }
    }
}
