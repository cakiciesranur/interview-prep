package examples;

import java.util.Map;
import java.util.stream.Collectors;

public class AmedeusQ1 {
    public static void main(String[] args) {
        String text = "aaaaabbccd";
        //System.out.println(encode(text));
        char[] chars = text.toCharArray();


        Map<Character, Integer> charCount = text.chars().boxed().collect(Collectors.toMap(
                k -> Character.valueOf((char) k.intValue()),
                v -> 1,
                Integer::sum));

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> item : charCount.entrySet()) {
            result.append(item.getValue()).append(item.getKey());
        }
        System.out.println(result.toString());
    }

/*    private static String encode(String text) {
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> charCount = text.chars().boxed().collect(Collectors.toMap(
                k -> Character.valueOf((char) k.intValue()),
                v -> 1,
                Integer::sum));
        System.out.println(charCount);
    }*/


}
