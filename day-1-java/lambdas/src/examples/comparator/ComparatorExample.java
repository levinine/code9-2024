package examples.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ComparatorExample {
    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort:");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort:");

        //lambda here!
        //listDevs.sort(new MyComparator());
        //listDevs.sort((Developer d1, Developer d2) -> d1.getAge() - d2.getAge());
        //listDevs.sort((d1, d2) -> d1.getAge() - d2.getAge());
        listDevs.sort(Comparator.comparingInt(Developer::getAge));

        //java 8 only, lambda also, to print the List
        listDevs.forEach(developer -> System.out.println(developer));
        //listDevs.forEach(System.out::println);

    }

    private static List<Developer> getDevelopers() {
        List<Developer> result = new ArrayList<>();

        result.add(new Developer("Djordje", 30));
        result.add(new Developer("Marko", 20));
        result.add(new Developer("Jovan", 10));
        result.add(new Developer("Irena", 50));

        return result;
    }
}
