package com.example.jpa.primer_ejemplo.service;

import com.example.jpa.primer_ejemplo.domain.Item;
import com.example.jpa.primer_ejemplo.respository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Set<Item> getAllItems(){
        Set<Item> setItems=new HashSet<>();
        itemRepository.findAll().forEach(item -> setItems.add(item));
        return setItems;
    }

    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    public Item updateItem(Item item,int id){
       return itemRepository.save(item);
    }

    public void deleteItem(int id){
        itemRepository.deleteById(id);
    }
}
