package com.github.carloscontrerasruiz.MockitoPractice.controller;

import com.github.carloscontrerasruiz.MockitoPractice.dto.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item getItem(){
        return new Item(1, "Item name", 10, 1);
    }
}
