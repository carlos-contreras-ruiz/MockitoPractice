package com.github.carloscontrerasruiz.MockitoPractice.controller;

import com.github.carloscontrerasruiz.MockitoPractice.dto.Item;
import com.github.carloscontrerasruiz.MockitoPractice.entity.ItemEntity;
import com.github.carloscontrerasruiz.MockitoPractice.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService service;

    @GetMapping("/dummy-item")
    public Item getItem(){
        return new Item(1, "Item name", 10, 1);
    }

    @GetMapping("/item-from-service")
    public Item itemFromService(){
        return service.retrieveHardcodeItem();
    }

    @GetMapping("/item-from-db")
    public List<ItemEntity> itemFromDb(){
        return service.retrieveAllItems();
    }
}
