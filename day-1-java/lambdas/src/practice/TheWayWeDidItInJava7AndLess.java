package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Believe it or not, this is how we did this just 9 years ago
public class TheWayWeDidItInJava7AndLess {

    public static void main(String[] args) {
        TheWayWeDidItInJava7AndLess hehe = new TheWayWeDidItInJava7AndLess();
        List<Integer> sums = hehe.calculate(100, 120);
        for (int i = 0; i < sums.size();  i++) {
            System.out.println(sums.get(i));
        }
        sums = hehe.calculateTheNewWay(100, 120);
        for (int i = 0; i < sums.size();  i++) {
            System.out.println(sums.get(i));
        }
    }

    /*
     * Distinct sums of all the palindrome numbers between two given numbers sorted in ascending order
    */
    public List<Integer> calculate(Integer start, Integer top) {
        List<Integer> result = new ArrayList<>();
        for (Integer i = start + 1; i < top; i++) {
            List<Integer> digits = separateIntoDigits(i);
            if (isPalindrome(digits)) {
                Integer sumOfDigits = sum(digits);
                if (!result.contains(sumOfDigits)) {
                    result.add(sumOfDigits);
                }
            }
        }

        result = sort(result);

        return result;
    }

    private List<Integer> sort(List<Integer> numbers) {
        Integer temp;
        for (int i = 0; i < numbers.size() - 2; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) > numbers.get(j)) {
                    temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }
        return numbers;
    }

    private List<Integer> separateIntoDigits(Integer number) {
        Integer digit;
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digit = number % 10;
            digits.add(0, digit);
            number /= 10;
        }
        return digits;
    }

    private boolean isPalindrome(List<Integer> digits) {
        int halfLength = digits.size() / 2;
        for (int i = 0; i < halfLength; i++) {
            if (digits.get(i) != digits.get(digits.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private Integer sum(List<Integer> digits) {
        Integer sum = 0;
        for (int i = 0; i < digits.size(); i++) {
            sum += digits.get(i);
        }
        return sum;
    }

    public List<Integer> calculateTheNewWay(Integer start, Integer top) {
        return IntStream.range(start + 1, top)
            .mapToObj(i -> Integer.valueOf(i))
            .map(this::separateIntoDigits)
            .filter(digits -> isPalindrome(digits))
            .map(digits -> digits.stream().reduce(0, Integer::sum))
            .distinct()
            .sorted((a, b) -> a.compareTo(b))
            .collect(Collectors.toList());
    }

}