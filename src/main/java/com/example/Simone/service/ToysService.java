package com.example.Simone.service;

import com.example.Simone.exception.ToysNotFoundException;
import com.example.Simone.mapper.ToysToToys;
import com.example.Simone.model.Toys;
import com.example.Simone.repository.ToysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToysService {

    @Autowired
    private ToysRepository toysRepository;

    @Autowired
    private ToysToToys toysToToys;

    public List<Toys> retrieveAllToys() {
        return toysRepository.findAll();
    }

    public Toys retrieveToysById(Long id) {
        return toysRepository.findById(id)
                .orElseThrow(() -> new ToysNotFoundException("no toys were found by the provided id"));
    }

    public void addToy(Toys toys) {
        toysRepository.save(toys);
    }

    public void deleteToyById(Long id) {
        toysRepository.deleteById(id);
    }

    public Toys updateToyById(Long id, Toys toys) {
        return toysRepository.save(toysRepository.findById(id)
                .map(toy -> toysToToys.from(toys))
                .orElseThrow(() -> new ToysNotFoundException("no toys were found by the provided id")));
    }
}
