package com.github.carloscontrerasruiz.MockitoPractice.service;

import com.github.carloscontrerasruiz.MockitoPractice.dto.Item;
import com.github.carloscontrerasruiz.MockitoPractice.entity.ItemEntity;
import com.github.carloscontrerasruiz.MockitoPractice.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class) //JUNIT4
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService service;

    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveHardcodeItemTest() {
        Item item = service.retrieveHardcodeItem();
        assertEquals(1,item.getId());
    }

    @Test
    public void retrieveAllItemsTest() {
        when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new ItemEntity(1, "Item name", 10, 10),
                        new ItemEntity(2, "Item name 2", 50, 10),
                        new ItemEntity(3, "Item name 3", 1, 10)
                )
        );

        List<ItemEntity> itemEntities = service.retrieveAllItems();

        assertEquals(3, itemEntities.size());

        assertEquals(itemEntities.get(0).getValue(),
                (itemEntities.get(0).getPrice() * itemEntities.get(0).getQuantity())
        );

        assertEquals(500,
                (itemEntities.get(1).getPrice() * itemEntities.get(1).getQuantity())
        );
    }
}