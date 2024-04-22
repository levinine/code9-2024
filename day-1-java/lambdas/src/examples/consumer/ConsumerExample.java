package examples.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("one", "three", "four");

        // implementation of the Consumer's accept methods.
        Consumer<String> consumer = x -> System.out.println(x);
        forEach(list, consumer);
        System.out.println("---------------------------");

        Consumer<String> consumer2 = x -> System.out.println(x + " (second consumer)");
        forEach(list, consumer.andThen(consumer2));
        System.out.println("---------------------------");

        // or call this directly
        forEach(list, x -> {
            System.out.print(x);
            System.out.println(", length: " + x.length());
        });

    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
