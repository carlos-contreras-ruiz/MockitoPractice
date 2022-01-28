package com.github.carloscontrerasruiz.MockitoPractice.service;

public class SOmeDataServiceImpl implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3,4,5,6};
    }
}
