package com.github.carloscontrerasruiz.MockitoPractice;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    List mock;

    @Before
    public void setup() {
        mock = mock(List.class);
    }

    @Test
    public void basicTest() {

        when(mock.size()).thenReturn(5);

        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValuesTest() {
        when(mock.size())
                .thenReturn(5)
                .thenReturn(10);

        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParametersTest() {
        when(mock.get(0))
                .thenReturn("Hello");

        assertEquals("Hello", mock.get(0));
    }

    @Test
    public void returnWithParametersAnyTest() {
        when(mock.get(anyInt()))
                .thenReturn("Hello");

        assertEquals("Hello", mock.get(0));
        assertEquals("Hello", mock.get(1));
    }
}
