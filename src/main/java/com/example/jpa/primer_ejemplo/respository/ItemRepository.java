package com.example.jpa.primer_ejemplo.respository;

import com.example.jpa.primer_ejemplo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
