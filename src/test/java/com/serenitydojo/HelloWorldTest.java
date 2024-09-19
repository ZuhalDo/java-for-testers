package com.serenitydojo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HelloWorldTest {

    @Test
    public void shouldWriteHelloWorldToTheConsole(){

        //System.out.println("Hello World");
        HelloWorld writer= new HelloWorld();
        writer.helloWorld();
    }

    @Test
    public void declaringNumericalVariables(){

        int age=42;
        age =age+1;
        System.out.println(age);
    }

    @Test
    public void WhenWorkingWithWholeNumbers(){

        int initialYear=1985;
        int targetYear=0;
        int timeJump=30;
        targetYear= initialYear + timeJump;
        assertThat(targetYear,equalTo(2015));
        System.out.println(targetYear);
    }
}
