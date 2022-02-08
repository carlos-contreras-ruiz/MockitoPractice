package com.github.carloscontrerasruiz.MockitoPractice;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class HamcrestMatchersTest {

    @Test
    public void learning(){
        List<Integer> integers = Arrays.asList(12, 15, 45);

        assertEquals(integers.size(),3);
        MatcherAssert.assertThat(integers, Matchers.hasItems(12,15));

        MatcherAssert.assertThat(integers,
                Matchers.everyItem(
                Matchers.greaterThan(10))
        );

        MatcherAssert.assertThat(integers,
                Matchers.everyItem(
                Matchers.lessThan(100))
        );

        MatcherAssert.assertThat("",Matchers.isEmptyString());
        MatcherAssert.assertThat("", Matchers.is(Matchers.emptyString()));
        MatcherAssert.assertThat("ABCD", Matchers.containsString("BCD"));
        MatcherAssert.assertThat("ABCD", Matchers.startsWith("AB"));
        MatcherAssert.assertThat("ABCD", Matchers.endsWithIgnoringCase("cd"));
    }
}
