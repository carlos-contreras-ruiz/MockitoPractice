package com.github.carloscontrerasruiz.MockitoPractice.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class) //JUNIT4
@WebMvcTest(value = ItemController.class)
class ItemControllerTest {

    @Test
    void getItem() {
    }
}