package examples;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AmedeusQ2 {
    public static void main(String[] args) {
        String text = "aaaaabbccd";
        char[] chars = text.toCharArray();

        Map<Character, Integer > charMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        int count= 0;
        for (char c :chars){
            if (charMap.containsKey(c)) {
                charMap.put(c,count+1);
            }else{
                result.append(c).append(count);
                charMap.remove(c);
                count=0;
                charMap.put(c,count);
            }


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
