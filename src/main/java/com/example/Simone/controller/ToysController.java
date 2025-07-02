package com.example.Simone.controller;

import com.example.Simone.exception.ToysNotFoundException;
import com.example.Simone.model.Toys;
import com.example.Simone.service.ToysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toys")
public class ToysController {

    @Autowired
    private ToysService toysService;

    @GetMapping("/giocattoli")
    public ResponseEntity<List<Toys>> getAllToys() {
        return ResponseEntity.ok(toysService.retrieveAllToys());
    }

    @GetMapping("/giocattoliById")
    public ResponseEntity<Toys> getToysById(@RequestParam Long id) {
        return ResponseEntity.ok(toysService.retrieveToysById(id));
    }

    @PostMapping("/giocattoli")
    public ResponseEntity<Void> addToy(@RequestBody Toys toys) {
        toysService.addToy(toys);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/giocattoli")
    public void deleteToy (@RequestParam Long id) {
        toysService.deleteToyById(id);
    }

    @PutMapping("/giocattoli")
    public ResponseEntity<Toys> updateToy(@RequestParam Long id, @RequestBody Toys toys) {
        return ResponseEntity.ok(toysService.updateToyById(id, toys));
    }
}
