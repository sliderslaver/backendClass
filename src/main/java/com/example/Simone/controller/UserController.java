package com.example.Simone.controller;

import com.example.Simone.model.CatFact;
import com.example.Simone.model.FattiSuiGatti;
import com.example.Simone.model.GarbageDTO;
import com.example.Simone.model.Users;
import com.example.Simone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utente")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<String> getUserWithParam(@RequestParam String userName){
        return ResponseEntity.ok(userService.retrieveUser(userName));
    }

    @GetMapping("/users")
    public ResponseEntity<Users> getUsersDetails() {
        return ResponseEntity.ok(userService.retrieveUsersDetails());
    }

    @GetMapping("/userByAge")
    public ResponseEntity<Users> getUsersDetailsa(@RequestParam int age) {
        return ResponseEntity.ok(userService.retrieveUsersDetailsFilteredByAge(age));
    }

    @GetMapping("/gattiFatti")
    public ResponseEntity<FattiSuiGatti> getGattiFatti() {
        return ResponseEntity.ok(userService.retrieveGattiFatti());
    }

    @GetMapping("/garbage")
    public ResponseEntity<GarbageDTO> getGarbage() {
        return ResponseEntity.ok(userService.retrieveGarbage());
    }

}
