package practice.results;

import practice.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static practice.FunWithStreams.personList;
import static practice.FunWithStreams.simpleStrings;

public class Results {

    public static void main(String[] args) {
        var results = new Results();

        System.out.println("-------------------1-------------------");
        results.resultOne();
        System.out.println("-------------------2-------------------");
        results.resultTwo();
        System.out.println("-------------------3-------------------");
        results.resultThree();
        System.out.println("-------------------4-------------------");
        results.resultFour();
        System.out.println("-------------------5-------------------");
        results.resultFive();
        System.out.println("-------------------6-------------------");
        results.resultSix();
        System.out.println("-------------------7-------------------");
        results.resultSeven();
    }

    /*
     * Print the count of empty Strings
     */
    public void resultOne() {
        long count = simpleStrings
                .stream()
                .filter(x -> x.isEmpty())
                .count();
        System.out.println("The number of empty Strings: " +  count);
    }

    /*
     * Print the new List without empty Strings
     */
    public void resultTwo() {
        List<String> filtered = simpleStrings
                .stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());
        System.out.println("Filtered list: " + filtered);
    }

    /*
     * Print all persons between the age of 22 and 45 sorted
     */
    public void resultThree() {
        System.out.println("Persons above 22 and under 45 years old are:");

        personList
                .stream()
                .filter(person -> person.getAge() > 22 && person.getAge() < 45)
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(person -> System.out.println(person.getName() + " age " + person.getAge()));
    }

    /*
     * Print the average age of persons that live in Novi Sad
     */
    public void resultFour() {
        personList
                .stream()
                .filter(person -> person.getCity().equals("Novi Sad"))
                .mapToDouble(Person::getAge)
                .average()
                .ifPresent(i -> System.out.println("Average age is: " + i));
    }

    /*
     * Group the persons by city, print the city and persons that live in it
     */
    public void resultFive() {
        personList.stream()
                .collect(Collectors.groupingBy(Person::getCity))
                .forEach((city, peopleInCity) -> {
                    System.out.println("City: " + city);
                    peopleInCity.forEach(person -> System.out.println("  " + person.getName() + " " + person.getSurname()));
                });
    }

    /* List all the cities persons are from */
    public void resultSix() {
        personList.stream()
                .map(Person::getCity)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /*
     * Move exactly one person from these cities
     * ["Novi Sad", "Beograd", "Subotica"]
     * to Kragujevac and print the result
     */
    public void resultSeven() {
        Stream.of("Novi Sad", "Beograd", "Subotica")
                .forEach(city -> personList.stream()
                                .filter(person -> city.equals(person.getCity()))
                                .findAny()
                                .map(person -> {
                                    person.setCity("Kragujevac");
                                    return person;
                                })
                                .ifPresent(System.out::println)
                        );
    }
}