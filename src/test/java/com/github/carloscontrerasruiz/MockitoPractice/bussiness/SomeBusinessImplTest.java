package com.github.carloscontrerasruiz.MockitoPractice.bussiness;


import com.github.carloscontrerasruiz.MockitoPractice.service.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
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
        verify(dataServiceMock, never()).retrieveAllData();
        assertEquals(0, calculateSum);
    }

    @Test
    public void calculateSumUsingService() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[]{1, 2, 3});

        int calculateSum = business.calculateSumUsingService();
        verify(dataServiceMock, times(1)).retrieveAllData();
        assertEquals(6, calculateSum);
    }

    @Test
    public void verificationBasics() {
        //SUT
        String value = mock.get(0);
        String value2 = mock.get(1);

        verify(mock, times(1)).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, never()).get(2);

    }

    @Test
    public void argumentCapturing() {
        mock.add("Something");
        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("Something", captor.getValue());
    }

    @Test
    public void argumentCapturingMultipleCalls() {
        mock.add("Something");
        mock.add("Something1");
        mock.add("Something2");
        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, atLeast(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("Something", allValues.get(0));
        assertEquals("Something1", allValues.get(1));
        assertEquals("Something2", allValues.get(2));
    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);

        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());

        when(arrayListMock.size()).thenReturn(5);
        when(arrayListMock.get(0)).thenReturn("Hola");

        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());

    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        //El spy se puede usar sin mockear la respuesta
        //Si se usa sin thenReturn usarar el codigo original del metodo
        //pero nos dejara verificar si el metodo fue llamado

        //El spy se comporta como la clase que mockeamos hasta
        //que le decimos que necesitamos que regrese
        arrayListSpy.add("Hola1");
        arrayListSpy.add("Hola2");
        arrayListSpy.add("Hola3");
        System.out.println(arrayListSpy.get(0));//Hola1
        System.out.println(arrayListSpy.size());//3

        when(arrayListSpy.size()).thenReturn(5);
        when(arrayListSpy.get(0)).thenReturn("Mock reslut");

        System.out.println(arrayListSpy.get(0));//Mock reslut
        System.out.println(arrayListSpy.size());//5

    }
}