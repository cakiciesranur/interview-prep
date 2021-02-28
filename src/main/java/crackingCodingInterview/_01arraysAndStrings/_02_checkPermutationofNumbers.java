package crackingCodingInterview._01arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two numbers, write a method to decide if one is a permutation of the
 * other.
 */
public class _02_checkPermutationofNumbers {
    public static void main(String[] args) {

        System.out.println(checkPermutation(4, 24));
    }

    private static boolean checkPermutation(int n, int k) {
        List<Integer> permutations = getPermutations(n);
        if (permutations.contains(k)) {
            return true;
        }
        return false;
    }

    private static List<Integer> getPermutations(int n) {
        // n! / (n-k)!
        List<Integer> list = new ArrayList<>();

        Integer nFactorial = getFactorial(n);
        for (int i = 1; i < n; i++) {
            list.add(nFactorial / getFactorial(i));
        }

        return list;
    }

    private static Integer getFactorial(int a) {
        int result;

        for (result = 1; a > 1; a--) {
            result *= a;
        }
        return result;
    }
}
