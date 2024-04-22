package examples.function;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> func1 = x -> x.length();
        Function<Integer, Integer> func2 = x -> x * 2;

        Integer result = func1.andThen(func2).apply("Code9");   // 10
        System.out.println(result);

        //Function<String, Integer> func1 = String::length;
    }
}
