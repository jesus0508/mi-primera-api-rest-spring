package com.example.jpa.primer_ejemplo.controller;

import com.example.jpa.primer_ejemplo.domain.Item;
import com.example.jpa.primer_ejemplo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseEntity<Set<Item>> findItems(){
        return new ResponseEntity<>(itemService.getAllItems(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        Item newItem=itemService.addItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item,@PathVariable int id){
        Item updateItem=itemService.updateItem(item,id);
        return new ResponseEntity<>(updateItem,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id){
        itemService.deleteItem(id);
    }

}
