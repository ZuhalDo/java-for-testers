package com.serenitydojo.checks;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WhenAddingNumbers {

    @Test
    public void shouldAddTwoIntegerCorrectly(){

        List<String> colors= Arrays.asList("red","blue","green");
        assertThat(colors).hasSize(3);
        assertThat(colors).contains("greenn");
    }
}
