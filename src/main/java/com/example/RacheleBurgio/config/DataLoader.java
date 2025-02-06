package com.example.RacheleBurgio.config;

import com.example.RacheleBurgio.Entity.*;

import com.example.RacheleBurgio.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initData(PizzaRepository pizzaRepo, DrinkRepository drinkRepo, ToppingRepository toppingRepo, TavoloRepository tavoloRepo, OrdineRepository ordineRepo) {
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

            Tavolo tavolo1 = new Tavolo(null, 1, false);
            Tavolo tavolo2 = new Tavolo(null, 2, false);
            tavoloRepo.saveAll(List.of(tavolo1, tavolo2));

            Ordine ordine = new Ordine();
            ordine.setTavolo(tavolo1);
            ordine.setMenuItems(List.of(margherita, cola));
            ordine.setTotale(margherita.getPrezzo() + cola.getPrezzo());
            ordineRepo.save(ordine);
        };
    }
}
