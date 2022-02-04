package com.github.carloscontrerasruiz.MockitoPractice.controller;

import com.github.carloscontrerasruiz.MockitoPractice.entity.ItemEntity;
import com.github.carloscontrerasruiz.MockitoPractice.repository.ItemRepository;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

//    @Autowired
//    private ItemRepository repository;

    //Con esta anotacion podemos mocker cualquier layer de la aplicacion
    //ya que con SpringBootTest levanta toda la aplicacion
    @MockBean
    private ItemRepository repository;

    @Before
    public void setup() {
//        List<ItemEntity> itemEntities = Arrays.asList(
//                new ItemEntity(1, "Item 1", 10, 5),
//                new ItemEntity(2, "Item 2", 5, 5),
//                new ItemEntity(3, "Item 3", 4, 5)
//        );
//        repository.saveAll(itemEntities);
        when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new ItemEntity(1, "Item 1", 10, 5),
                        new ItemEntity(2, "Item 2", 5, 5),
                        new ItemEntity(30, "Item 3", 4, 5)
                )
        );
    }

    @Test
    public void getAllItemsDB() throws JSONException {
        String response = this.restTemplate.getForObject("/item-from-db", String.class);
        JSONAssert.assertEquals("[{id:1},{id:2},{id:30}]", response, false);
    }
}
