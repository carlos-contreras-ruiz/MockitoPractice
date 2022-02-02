package com.github.carloscontrerasruiz.MockitoPractice.service;

import com.github.carloscontrerasruiz.MockitoPractice.dto.Item;
import com.github.carloscontrerasruiz.MockitoPractice.entity.ItemEntity;
import com.github.carloscontrerasruiz.MockitoPractice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodeItem() {
        return new Item(1, "Item name form service", 10, 1);
    }

    public List<ItemEntity> retrieveAllItems() {
        List<ItemEntity> itemEntities = repository.findAll().stream().map(
                item -> {
                    item.setValue(item.getPrice() * item.getQuantity());
                    return item;
                }
        ).collect(Collectors.toList());
        return itemEntities;
    }


}
