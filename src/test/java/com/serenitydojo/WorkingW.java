package com.serenitydojo;

import org.junit.Test;

public class WorkingW
{

    @Test
    public void convertLowerCase(){

        String name="    Denis Atlas ";
        System.out.println(name.toLowerCase());
        System.out.println(name.toUpperCase());
        System.out.println(name.trim());
        System.out.println(name.length());
        System.out.println(name.replace("Denis","Deniz"));
    }
}
