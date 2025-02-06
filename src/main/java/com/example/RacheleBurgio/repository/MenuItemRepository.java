package com.example.RacheleBurgio.repository;

import com.example.RacheleBurgio.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
