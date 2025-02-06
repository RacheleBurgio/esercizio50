package com.example.RacheleBurgio.config;

import com.example.RacheleBurgio.Entity.Drink;
import com.example.RacheleBurgio.Entity.Pizza;
import com.example.RacheleBurgio.Entity.Topping;

import com.example.RacheleBurgio.repository.DrinkRepository;
import com.example.RacheleBurgio.repository.PizzaRepository;
import com.example.RacheleBurgio.repository.ToppingRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initData(PizzaRepository pizzaRepo, DrinkRepository drinkRepo, ToppingRepository toppingRepo) {
        return args -> {
            Topping mozzarella = new Topping(null, "Mozzarella", 1.50);
            Topping funghi = new Topping(null,"Funghi", 2.00);
            toppingRepo.saveAll(List.of(mozzarella, funghi));

            Pizza margherita = new Pizza(null,"Margherita", 8.00, List.of(mozzarella));
            Pizza funghiPizza = new Pizza(null,"Funghi", 10.00, List.of(mozzarella, funghi));
            pizzaRepo.saveAll(List.of(margherita, funghiPizza));

            Drink cola = new Drink(null, "Coca-Cola", 2.50);
            Drink birra = new Drink(null,"Birra", 3.50);
            drinkRepo.saveAll(List.of(cola, birra));
        };
    }
}
