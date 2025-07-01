package com.example.Simone.database;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FakeUserDatabase implements UserDatabase{
    @Override
    public List<String> retrieveUserName() {
        return List.of("Simone", "Monica", "Federica");
    }
}
