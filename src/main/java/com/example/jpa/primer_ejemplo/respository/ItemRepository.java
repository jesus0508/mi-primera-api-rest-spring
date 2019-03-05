package com.example.jpa.primer_ejemplo.respository;

import com.example.jpa.primer_ejemplo.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Integer> {
}
