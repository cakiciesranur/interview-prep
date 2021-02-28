package examples;

import java.util.List;
import java.util.stream.IntStream;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
* */
public class FizzBuzz {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .mapToObj(i -> i % 5 == 0 ? (i % 3 == 0 ? "FizzBuzz" : "Fizz") : (i % 3 == 0 ? "Buzz" : i))
                .forEach(System.out::println);
    }

    public static void fizzBuzz(int[] n) {



    }

}
