package com.example.Simone.service;

import com.example.Simone.client.CatFactClient;
import com.example.Simone.client.UserDetailClient;
import com.example.Simone.database.UserDatabase;
import com.example.Simone.exception.UserGenericErrorException;
import com.example.Simone.mapper.AllToGarbageDTO;
import com.example.Simone.mapper.CatFactToFattiSuiGatti;
import com.example.Simone.model.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDatabase userDatabase;

    @Autowired
    private UserDetailClient userDetailClient;

    @Autowired
    private CatFactClient catFactClient;

    @Autowired
    private CatFactToFattiSuiGatti catFactToFattiSuiGatti;

    @Autowired
    private AllToGarbageDTO allToGarbageDTO;

    public String retrieveUser(String userName) {
        if (userDatabase.retrieveUserName().contains(userName)) {
            return userName;
        }
        return "No Match";
    }

    public Users retrieveUsersDetails() {
        return userDetailClient.retrieveUserDetails();
    }

    public Users retrieveUsersDetailsFilteredByAge(int age) {
        Users users = userDetailClient.retrieveUserDetails();
        List<User> filteredUsers = new ArrayList<>();

        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getAge() == age) {
                filteredUsers.add(users.getUsers().get(i));
            }
        }

        users.setUsers(filteredUsers);
        return users;
    }

    public FattiSuiGatti retrieveGattiFatti() {
        return Optional.ofNullable(catFactClient.getCatFact())
                .map(HttpEntity::getBody)
                .map(catFactToFattiSuiGatti::from)
                .orElseThrow(RuntimeException::new);
    }

    public GarbageDTO retrieveGarbage() {
        val username = userDatabase.retrieveUserName().stream()
                .findFirst()
                .orElseThrow();

        val userDetail = userDetailClient.retrieveUserDetails()
                .getUsers()
                .stream()
                .findFirst()
                .orElseThrow(UserGenericErrorException::new);

        val fattoSuiGatti =  Optional.ofNullable(catFactClient.getCatFact())
                .map(HttpEntity::getBody)
                .orElseThrow(RuntimeException::new);

        return allToGarbageDTO.from(username, userDetail, fattoSuiGatti);
    }

    public static String randomString(String nome) {
        return nome.concat(" lo stupido");
    }
}
