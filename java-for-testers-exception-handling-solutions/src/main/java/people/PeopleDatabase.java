package people;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PeopleDatabase {
    List<Person> allThePeople;

    public PeopleDatabase(List<Person> allThePeople) {
        this.allThePeople = allThePeople;
    }

    public List<Person> findPeopleUnder35() {
        List<Person> peopleUnder35 = new ArrayList<>();
        for (Person person : allThePeople) {
            if (person.getAge() < 35) {
                peopleUnder35.add(person);
            }
        }

        return peopleUnder35;
    }

    public List<Person> findPeopleWhoLikeRed() {
        List<Person> peopleWhoLikeRed = new ArrayList<>();
        for (Person person : allThePeople) {
            if (person.getFavouriteColor().equals("Red")) {
                peopleWhoLikeRed.add(person);
            }
        }
        return peopleWhoLikeRed;
    }

    //Lambda
    public List<Person> findPeopleBetween(int lowestAge, int highestAge) {

        return null;
    }

    public List<Person> findAllPeopleWho(Predicate<Person> check) {

        return allThePeople.stream()
                .filter(check)
                .collect(Collectors.toList());


//        List<Person> matchingPeople = new ArrayList<>();
//        for (Person person : allThePeople) {
//            if (check.test(person)) {
//                matchingPeople.add(person);
//            }
//
//        }
//        return matchingPeople;
    }
}
