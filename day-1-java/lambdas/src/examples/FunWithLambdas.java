package examples;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunWithLambdas {

    // it can be a static member
    private static Runnable helloWorldPrinter = () -> System.out.println("This is a \"Hello world\" runnable");

    public static void main(String[] args) {
        FunWithLambdas.helloWorldPrinter.run();

        Integer[] numbers = {1, 2, 3, 4, 5};
        var fun = new FunWithLambdas();
        fun.showOff(numbers);

        // some can work with two input objects
        BiConsumer<Integer, String> biConsumer = (a,b) -> System.out.printf("CEO, %s, born in %d...\n", b, a);
        biConsumer.accept(1964, "entrepeneur");
    }

    // it can be a private member
    // Function<T, R> ingests object of type T and transforms it into object of type R
    private Function<Integer, Integer> adder = i -> i + 1;
    // Predicate<T> ingests object of type T and passes it further down the stream if given condition is met
    private Predicate<Integer> isItOdd = i -> i % 2 != 0;

    // functions can be used as lambdas too
    private Integer addOneMore(Integer a) {
        return a + 1;
    }

    public void showOff(Integer[] numbers) {
        // Consumer<T> ingests object of type T and does a final action on it. The journey ends here.
        Consumer<Integer> outputer = i -> System.out.println(i);

        Arrays.stream(numbers)
            .filter(this.isItOdd)
            .map(this.adder)
            .map(this::addOneMore)
            .forEach(outputer);
    }
}
