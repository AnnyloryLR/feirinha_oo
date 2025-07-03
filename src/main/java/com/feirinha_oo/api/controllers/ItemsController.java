package com.feirinha_oo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinha_oo.api.services.ItemsService;

import jakarta.validation.Valid;

import com.feirinha_oo.api.dtos.ItemDTO;
import com.feirinha_oo.api.models.ItemsModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;


@RestController
@RequestMapping("/items")
public class ItemsController {

    final ItemsService itemsService;

    ItemsController( ItemsService itemsService ){
        this.itemsService = itemsService;
    }

    @GetMapping()
    public ResponseEntity<Object> getItems(){
        return ResponseEntity.status(HttpStatus.OK).body(itemsService.getItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable Long id){
        Optional<ItemsModel> item = itemsService.getItemById(id);

        if(!item.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item with this id not found!");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(item.get());
        }
    }

    @PostMapping()
    public ResponseEntity<Object> createItem(@RequestBody @Valid ItemDTO body){
        Optional<ItemsModel> item = itemsService.createItem(body);

        if(!item.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("An item with this name already exists.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(item.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable Long id, @RequestBody @Valid ItemDTO body){
        Optional<ItemsModel> item = itemsService.updateItem(id, body);

        if(!item.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(item.get());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> deleteItem(@PathVariable Long id){
        Optional<ItemsModel> item = itemsService.getItemById(id);

        if(!item.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item with this id not found!");
        }
        
        itemsService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }  
       
}
