package com.example.Simone.repository;

import com.example.Simone.model.Toys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToysRepository extends JpaRepository<Toys, Long> {
}
