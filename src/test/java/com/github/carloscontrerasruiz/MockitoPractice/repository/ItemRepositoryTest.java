package com.github.carloscontrerasruiz.MockitoPractice.repository;

import com.github.carloscontrerasruiz.MockitoPractice.entity.ItemEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @BeforeAll
    public void setup() {
        List<ItemEntity> itemEntities = Arrays.asList(
                new ItemEntity(1, "Item 1", 10, 5),
                new ItemEntity(2, "Item 2", 5, 5),
                new ItemEntity(3, "Item 3", 4, 5)
        );
        repository.saveAll(itemEntities);
    }

    @Test
    public void testFindAll() {
        List<ItemEntity> items = repository.findAll();
        assertEquals(3, items.size());
    }
}