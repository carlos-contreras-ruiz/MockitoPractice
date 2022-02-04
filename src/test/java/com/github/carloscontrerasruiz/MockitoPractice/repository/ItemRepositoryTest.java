package com.github.carloscontrerasruiz.MockitoPractice.repository;

import com.github.carloscontrerasruiz.MockitoPractice.entity.ItemEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Before
    public void setup(){
        List<ItemEntity> itemEntities = Arrays.asList(
                new ItemEntity(1, "Item 1", 10, 5),
                new ItemEntity(2, "Item 2", 5, 5),
                new ItemEntity(3, "Item 3", 4, 5)
        );
        repository.saveAll(itemEntities);
    }

    @Test
    public void testFindAll(){
        List<ItemEntity> items = repository.findAll();
        assertEquals(3,items.size());
    }
}