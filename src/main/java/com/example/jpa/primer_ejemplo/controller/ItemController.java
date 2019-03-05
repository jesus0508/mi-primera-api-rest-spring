package com.example.jpa.primer_ejemplo.controller;

import com.example.jpa.primer_ejemplo.entity.Item;
import com.example.jpa.primer_ejemplo.respository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        Item newItem=itemRepository.saveAndFlush(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@RequestBody Item item,@PathVariable int id){
        Item updateItem=itemRepository.saveAndFlush(item);
        return new ResponseEntity<>(updateItem,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public void deleteItem(@PathVariable Integer id){
        itemRepository.deleteById(id);
    }

}
