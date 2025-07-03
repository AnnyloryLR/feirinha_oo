package com.feirinha_oo.api.services;

import org.springframework.stereotype.Service;

import com.feirinha_oo.api.dtos.ItemDTO;
import com.feirinha_oo.api.models.ItemsModel;
import com.feirinha_oo.api.repositories.ItemsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {
    
    final ItemsRepository itemsRepository;

    ItemsService(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    public List<ItemsModel> getItems(){
        return itemsRepository.findAll();
    }

    public Optional<ItemsModel> getItemById(Long id){
        Optional<ItemsModel> item = itemsRepository.findById(id);

        if(!item.isPresent()){
            return Optional.empty();
        }else{
            return Optional.of(item.get());
        }
    }

    public ItemsModel createItem(ItemDTO body){
        ItemsModel item =  new ItemsModel(body);
        itemsRepository.save(item);
        return item;
    }

    public Optional<ItemsModel> updateItem(Long id, ItemDTO body){
        Optional<ItemsModel> item = itemsRepository.findById(id);

        if(!item.isPresent()){
            return Optional.empty();
        }

        ItemsModel editedItem = new ItemsModel(body);
        editedItem.setId(id);
        itemsRepository.save(editedItem);
        return Optional.of(editedItem);
    }

    public void deleteItem(Long id){
        itemsRepository.deleteById(id);
    }  

}
