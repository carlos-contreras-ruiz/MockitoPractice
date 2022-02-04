package com.github.carloscontrerasruiz.MockitoPractice.controller;


import com.github.carloscontrerasruiz.MockitoPractice.dto.Item;
import com.github.carloscontrerasruiz.MockitoPractice.entity.ItemEntity;
import com.github.carloscontrerasruiz.MockitoPractice.service.ItemBusinessService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService service;

    public static final String CONTENT = "{\"id\":1,\"name\":\"Item name\",\"price\":10,\"quantity\":1}";

    public static final String CONTENT_ARRAY = "[{\"id\":1,\"name\":\"Item name\",\"price\":10,\"quantity\":10}," +
            "{\"id\":2,\"name\":\"Item name 2\",\"price\":50,\"quantity\":10}," +
            "{\"id\":3,\"name\":\"Item name 3\",\"price\":1,\"quantity\":10}]";

    @BeforeEach
    public void setup() {
        when(service.retrieveHardcodeItem()).thenReturn(
                new Item(1, "Item name", 10, 1)
        );
        when(service.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new ItemEntity(1, "Item name", 10, 10),
                        new ItemEntity(2, "Item name 2", 50, 10),
                        new ItemEntity(3, "Item name 3", 1, 10)
                )
        );
    }

    @Test
    public void getItemBasic() throws Exception {
        //call /dummy-item
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(CONTENT))
                .andReturn();
    }

    @Test
    public void getItemWithService() throws Exception {
        //call /dummy-item
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(CONTENT))
                .andReturn();
    }

    @Test
    public void getItemsFromDb() throws Exception {
        //call /dummy-item
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-db")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(CONTENT_ARRAY))
                .andReturn();
    }
}