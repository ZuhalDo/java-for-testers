package lambdas;

import org.junit.Test;
import org.yecht.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WhenUsingLambdas {

    @Test
    public void printOutColors(){

        List<String> colors = Arrays.asList("red","green","blue");

        colors.forEach(
               // WhenUsingLambdas::printColorOf
               color -> {
                   if(color.equals("red"))
                       System.out.println("RED!");
                   else
                       System.out.println(color);
               }
        );

       // for(String c :colors){
       //     printColorOf(c);
       // }
    }

   // public  static void  printColorOf(String color){
   //     System.out.println("COLOR: " +color);
  //  }

    @Test
    public void filteringColors() {

        List<String> colors = Arrays.asList("red", "green", "blue","grey","grey-blue","gritty white");

       List<String> filteredColors= colors.stream()
                .filter(color ->color.startsWith("g"))
               .map(color ->color.toUpperCase())
               .sorted()
                .collect(Collectors.toList());

        System.out.println(filteredColors);

    }
}
