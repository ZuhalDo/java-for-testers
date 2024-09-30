import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class WhenWorkingWithDates {

    @Test
    public void creatingATimestampForToday(){

        LocalDate today = LocalDate.now();
        System.out.println("Today is " + today);
    }

    @Test
    public void creatingAGivenDate(){
        LocalDate fourthOfJuly = LocalDate.of(2024,7,1);
        System.out.println(fourthOfJuly);
    }

    @Test
    public void parsingADate(){
        String dateInStringForm="2024-05-01";
        LocalDate firstOfMay= LocalDate.parse(dateInStringForm);
        System.out.println(firstOfMay);
    }

    @Test
    public void parsingADateWithAGivenFormat(){
        LocalDate mayFirst = LocalDate.parse("05/01/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(mayFirst);
    }

    @Test
    public void yesterday(){
        LocalDate today =LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        System.out.println(yesterday);
    }

    @Test
    public void checkingTheMonth(){

        LocalDate today =LocalDate.now();
        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getDayOfMonth());

    }

    @Test
    public void comparingDates(){
        LocalDate firstDay =LocalDate.of(2024,9,1);
        LocalDate fifthDay =LocalDate.of(2024,9,5);
        LocalDate tenthDay =LocalDate.of(2024,9,10);

       // Assertions.assertThat(firstDay).isAfter(fifthDay);
        Assertions.assertThat(firstDay).isBefore(fifthDay);
        Assertions.assertThat(fifthDay).isBetween(fifthDay,tenthDay);
    }

    @Test
    public void usingTime(){

        LocalTime now= LocalTime.now();
        LocalTime fiveHoursAgo = now.minusHours(5);
        System.out.println(fiveHoursAgo);
    }
}
