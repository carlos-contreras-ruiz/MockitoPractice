package com.github.carloscontrerasruiz.MockitoPractice;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

        assertEquals(numbers.size(), 3);

        //NUMBERS
        Assertions.assertThat(numbers)
                .hasSize(3)
                .contains(12, 15)
                .allMatch(i -> i > 10)
                .allMatch(i -> i < 100)
                .noneMatch(i -> i == 40);

        //STRINGS
        String testString = "ABCDE";

        Assertions.assertThat("").isEmpty();
        Assertions.assertThat(testString).isNotEmpty();
        Assertions.assertThat(testString)
                .contains("AB")
                .containsIgnoringCase("cd")
                .startsWith("AB")
                .endsWith("DE")
                .doesNotEndWith("OP");

    }
}
