package com.serenitydojo.checks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WhenWorkingWithMaps {

    @Test
    public void creatingMap() {
        Map<String, Integer> numberOfBallsByColor = new HashMap<>();
        numberOfBallsByColor.put("red",3);
        numberOfBallsByColor.put("green",6);
        numberOfBallsByColor.put("blue",5);
        Integer numberofRedBalls=numberOfBallsByColor.get("red");
        System.out.println(numberofRedBalls);
    }

    @Test
    public void creatingMoreConvinceMap(){

        Map<String,Integer> numberOfBalls=Map.of("red",3,"green",5,"blue",6);
        Map<String ,Integer> moreColors=new HashMap<>();
        moreColors.put("yellow",10);
        moreColors.put("mauve",0);
        moreColors.putAll(numberOfBalls);
        moreColors.put("yellow",20);
        moreColors.replace("pink",15);


        System.out.println(moreColors.getOrDefault("pink",0));
    }

    @Test
    public void iteratingOverMapKeys(){
        Map<String,Integer> numberOfBalls=Map.of("red",3,"green",5,"blue",6);

        System.out.println("Keys =" + numberOfBalls);

        for(String key: numberOfBalls.keySet()){

            Integer numberOfTennisBall=numberOfBalls.get(key);
            System.out.println(key + "=>" +numberOfTennisBall);
        }

        for(Map.Entry<String ,Integer> entry : numberOfBalls.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

    }

}
