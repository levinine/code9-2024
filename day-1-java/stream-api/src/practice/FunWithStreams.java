package practice;

import java.util.*;

public class FunWithStreams {

    public static List<Person> personList = Arrays.asList(
        new Person("Marko", "Markovic", 20, "Novi Sad"),
        new Person("Janko", "Jankovic", 22, "Beograd"),
        new Person("Milos", "Misic", 32, "Zrenjanin"),
        new Person("Milica", "Matic", 65, "Novi Sad"),
        new Person("Steva", "Ristic", 17, "Novi Sad"),
        new Person("Filip", "Fimic", 44, "Pancevo"),
        new Person("Filip", "Jakovljevic", 27, "Novi Sad")
    );

    public static List<String> simpleStrings = Arrays.asList("abc", "", "bcd", "", "defg", "", "jk");

    public static void main(String[] args) {
        FunWithStreams streams = new FunWithStreams();

        System.out.println("-------------------1-------------------");
        streams.exerciseOne();

        System.out.println("-------------------2-------------------");
        streams.exerciseTwo();

        System.out.println("-------------------3-------------------");
        streams.exerciseThree();

        System.out.println("-------------------4-------------------");
        streams.exerciseFour();

        System.out.println("-------------------5-------------------");
        streams.exerciseFive();
    }

    /*
     * Print the count of empty Strings
     */
    public void exerciseOne() {
        int count = 0;

        for (String str : simpleStrings) {
            if (str.isEmpty()) {
                count++;
            }
        }
        System.out.println("The number of empty Strings: " +  count);
    }

    /*
     * Print a new List without empty Strings
     */
    public void exerciseTwo() {
        List<String> filtered = new ArrayList<>();

        for (String str : simpleStrings) {
            if (!str.isEmpty()) {
                filtered.add(str);
            }
        }
        System.out.println("Filtered list: " + filtered);
    }

    /*
     * Print all persons between the age of 22 and 45 sorted
     */
    public void exerciseThree() {
        System.out.println("Persons above 22 and under 45 years old are:");

        List<Person> filteredPersons = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge() > 22 && person.getAge() < 45 ) {
                filteredPersons.add(person);
            }
        }
        Collections.sort(filteredPersons, Comparator.comparingInt(Person::getAge));
        for (Person person : filteredPersons) {
            System.out.println(person.getName() + " age " + person.getAge());
        }
    }

    /*
     * Print the average age of persons that live in Novi Sad
     */
    public void exerciseFour() {
        double avgAge = 0;
        double divider = 0;
        for (Person person : personList) {
            if (person.getCity().equals("Novi Sad")) {
                avgAge += person.getAge();
                divider ++;
            }
        }
        System.out.println("Average age is: " + avgAge / divider);
    }

    /*
     * Group the persons by city, print the city and persons that live in it
     */
    public void exerciseFive() {
        Map<String, List<Person>> peopleByCity = new HashMap<>();

        for (Person person : personList) {
            String city = person.getCity();
            List<Person> peopleInCity = peopleByCity.get(city);
            if (peopleInCity == null) {
                peopleInCity = new ArrayList<>();
                peopleByCity.put(city, peopleInCity);
            }
            peopleInCity.add(person);
        }

        for (var entry : peopleByCity.entrySet()) {
            String city = entry.getKey();
            List<Person> peopleInCity = entry.getValue();

            System.out.println("City: " + city);
            for (Person person : peopleInCity) {
                System.out.println("  " + person.getName() + " " + person.getSurname());
            }
        }
    }
}