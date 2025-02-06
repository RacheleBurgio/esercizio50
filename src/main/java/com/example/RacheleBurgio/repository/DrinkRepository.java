package com.example.RacheleBurgio.repository;

import com.example.RacheleBurgio.Entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findByNome(String nome);
    @Query("SELECT d FROM Drink d WHERE d.prezzo < :prezzoMax")
    List<Drink> findDrinksCheaperThan(@Param("prezzoMax") double prezzoMax);
}

