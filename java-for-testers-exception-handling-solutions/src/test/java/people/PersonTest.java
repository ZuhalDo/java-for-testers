package people;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    Person sam= new Person("Sam", Person.Gender.FEMALE,30,"Green");
    Person bill=new Person("Bill", Person.Gender.MALE,40,"Blue");
    Person tim=new Person("Tim", Person.Gender.MALE,10,"Red");
    Person susan = new Person("Susan", Person.Gender.FEMALE,50,"Red");
    List<Person> allThePeople= Arrays.asList(sam,bill,tim,susan);

    Predicate<Person> LIKE_GREEN = person -> person.getFavouriteColor().equals("Green");
    PersonChecker LIKE_BLUE =  person -> person.getFavouriteColor().equals("Blue");
    Predicate<Person> LIKE_RED = person -> person.getFavouriteColor().equals("Red");
    //Predicate<Person> BETWEEN_20_AND_40 =
    Predicate<Person> UNDER_35 = person -> person.getAge() < 35;


    @Test
    public void ICanCreateSomePeople(){

        System.out.println(allThePeople);
    }
    @Test
    public void ICanSearchForPeopleByAge(){
        //search for people under 35
        PeopleDatabase people=new PeopleDatabase(allThePeople);

        List<Person> peopleUnder35=people.findAllPeopleWho(UNDER_35);

        assertThat(peopleUnder35).contains(sam,tim);
    }

    @Test
    public void ICanSearchForPeopleBetween20And40(){
        //search for people under 35
        PeopleDatabase people=new PeopleDatabase(allThePeople);

        List<Person> peopleUnder35=people.findPeopleBetween(20,40);

        assertThat(peopleUnder35).contains(sam,bill,susan);
    }
    @Test
    public void WhoLikeRed(){

        PeopleDatabase people= new PeopleDatabase(allThePeople);

        List<Person> peopleWhoLikeRed=people.findAllPeopleWho(LIKE_RED);

        assertThat(peopleWhoLikeRed).contains(tim,susan);
    }
    @Test
    public void ICanSearchForPeopleWhoLikeGreen(){

        PeopleDatabase people= new PeopleDatabase(allThePeople);

        List<Person> matchingPeople=people.findAllPeopleWho(LIKE_GREEN);

        assertThat(matchingPeople).contains(sam);
    }

    @Test
    public void peopleEarnPoints(){
        allThePeople.forEach(
                person -> person.earnPoints(100)
        );

        allThePeople.forEach(
                person -> System.out.println("points for " + person.getName() +
                       " = " + person.getPoints())
        );
    }
    @Test
    public void peopleEarnPointsPeek() {
        allThePeople.parallelStream()
                .peek(person -> System.out.println("Points for " + person.getName() +
                        " = " + person.getPoints()))
                .peek(person -> person.earnPoints(100))
                .forEach(person -> System.out.println("Updated Points for " + person.getName() +
                        " = " + person.getPoints()));

    }
    @Test
    public void peopleColors(){

        List<String> allTheColors = allThePeople.stream()
                .map(Person::getFavouriteColor)
               // .sorted(Comparator.reverseOrder())
                .sorted(Comparator.comparing(String::length))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(allTheColors);

    }

}
