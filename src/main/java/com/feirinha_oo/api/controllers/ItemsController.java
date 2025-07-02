package com.feirinha_oo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinha_oo.api.repositories.ItemsRepository;
import com.feirinha_oo.api.models.ItemsModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemsController {

    final ItemsRepository itemsRepository;

    ItemsController( ItemsRepository itemsRepository ){
        this.itemsRepository = itemsRepository;
    }

    @GetMapping()
    public List<ItemsModel> getItems(){
        return itemsRepository.findAll();
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable Long id){
        return "Receita de id " + id;
    }

    @PostMapping()
    public String createItem(@RequestBody String body){
        return body;
    }

    @PutMapping("/{id}")
    public String updateItem(@PathVariable Long id, @RequestBody String body){
        return body;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id){
        return "Deletando item " + id;
    }  
       
}
