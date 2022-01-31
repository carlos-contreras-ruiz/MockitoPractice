package com.github.carloscontrerasruiz.MockitoPractice.service;

import org.springframework.stereotype.Service;

@Service
public class SomeDataServiceImpl implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3,4,5,6};
    }
}
