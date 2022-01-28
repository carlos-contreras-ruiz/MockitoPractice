package com.github.carloscontrerasruiz.MockitoPractice.bussiness;


import com.github.carloscontrerasruiz.MockitoPractice.service.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplTest {

    @Mock
    SomeDataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl business;

    List<String> mock = mock(List.class);


    @Test
    public void calculateSumTest() {
        int calculateSum = business.calculateSum(new int[]{1, 2, 3, 1});
        assertEquals(7, calculateSum);
    }

    @Test
    public void calculateSumEmptyTest() {
        int calculateSum = business.calculateSum(new int[]{});
        assertEquals(0, calculateSum);
    }

    @Test
    public void calculateSumNullTest() {
        int calculateSum = business.calculateSum(null);
        verify(dataServiceMock,never()).retrieveAllData();
        assertEquals(0, calculateSum);
    }

    @Test
    public void calculateSumUsingService() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[]{1, 2, 3});

        int calculateSum = business.calculateSumUsingService();
        verify(dataServiceMock,times(1)).retrieveAllData();
        assertEquals(6, calculateSum);
    }

    @Test
    public void verificationBasics(){
        //SUT
        String value = mock.get(0);
        String value2 = mock.get(1);

        verify(mock,times(1)).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock, never()).get(2);

    }
}