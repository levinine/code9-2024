package examples.supplier;

import examples.comparator.Developer;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample {
    Supplier<Developer> developerSupplier = Developer::new;
    //Developer developer = Developer::new; // Developer is not functional interface

    public static void main(String[] args) {
        Supplier<Integer> randomNumbersSupp = () -> new Random().nextInt(10);
        Stream.generate(randomNumbersSupp)
                .limit(5)
                .forEach(System.out::println);
    }
}
