package com.example.Simone.controller;

import com.example.Simone.model.Toys;
import com.example.Simone.repository.ToysRepository;
import com.example.Simone.service.ToysService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ToysControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ToysRepository toysRepository;

    @Test
    void getAllToys() throws Exception {

        val firstToy = Toys.builder()
                .ageRating(15)
                .price(76)
                .inStock(false)
                .productName("Crash Bandicoot")
                .build();

        val secondToy = Toys.builder()
                .ageRating(18)
                .price(100000)
                .inStock(true)
                .productName("Beyond Two Souls")
                .build();

        toysRepository.saveAll(List.of(firstToy, secondToy));

        mockMvc.perform(get("/toys/giocattoli"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].price").value(76))
                .andExpect(jsonPath("$[1].price").value(100000));
    }

    @Test
    void getToysById() {
    }

    @Test
    void addToy() {
    }

    @Test
    void deleteToy() {
    }

    @Test
    void updateToy() {
    }
}