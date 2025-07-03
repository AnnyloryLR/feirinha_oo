package com.feirinha_oo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinha_oo.api.repositories.ItemsRepository;

import jakarta.validation.Valid;

import com.feirinha_oo.api.dtos.ItemDTO;
import com.feirinha_oo.api.models.ItemsModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;


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
    public Optional<ItemsModel> getItemById(@PathVariable Long id){
        Optional<ItemsModel> item = itemsRepository.findById(id);

        if(!item.isPresent()){
            return Optional.empty();
        }else{
            return Optional.of(item.get());
        }
    }

    @PostMapping()
    public void createItem(@RequestBody @Valid ItemDTO body){
        ItemsModel item =  new ItemsModel(body);
        itemsRepository.save(item);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody @Valid ItemDTO body){
        Optional<ItemsModel> item = itemsRepository.findById(id);

        if(!item.isPresent()){

        }

        ItemsModel editedItem = new ItemsModel(body);
        editedItem.setId(id);
        itemsRepository.save(editedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        itemsRepository.deleteById(id);
    }  
       
}
