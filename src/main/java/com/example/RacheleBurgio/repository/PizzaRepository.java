package com.example.RacheleBurgio.repository;

import com.example.RacheleBurgio.Entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findByNomeContaining(String nome);
}