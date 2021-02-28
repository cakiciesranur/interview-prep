package examples;

import java.util.List;
/*find Element from the list hackerrank*/

public class FindElement {
    public static void main(String[] args) {

    }

    static String findElement(List<Integer> arr, int k) {
        if (arr == null) {
            return "NO";
        }
        if (arr.contains(k)) {
            return "YES";
        }

        return "NO";
    }
}
