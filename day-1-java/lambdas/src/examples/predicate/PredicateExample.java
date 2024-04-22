package examples.predicate;

import examples.comparator.Developer;

import java.util.function.Predicate;

public class PredicateExample {
    Predicate<Developer> predicate = d -> d.getAge() >= 2000000;

    public static void main(String[] args) {

        Predicate<String> startWithA = x -> x.startsWith("a");
        Predicate<String> startWithD = x -> x.startsWith("d");

        // start with "a" or "d"
        System.out.println("anita: " + startWithA.or(startWithD).test("anita"));
        System.out.println("milan: " + startWithA.or(startWithD).test("milan"));
        System.out.println("davor: " + startWithA.or(startWithD).test("davor"));

        // !(start with "a" and length is 3)
        System.out.println("abc: " + startWithA.and(x -> x.length() == 3).negate().test("abc"));

    }
}
