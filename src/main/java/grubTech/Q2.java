package grubTech;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Let's imagine that your friend has sent you an invitation to his secret party.
 * The information in the invitation is encrypted. But you've got the instructions on how to decrypt it.
 * Words are not in the correct order. You need to:
 */
public class Q2 {
    public static void main(String[] args) {

        //decryption("t1e1s2t, Hell1o, 1th1e, fir2st1");
        decryption("1yo1ur; ro2ckst2ar;i2nn1er. us6, Come unl1eash 2wi2th1;");
    }

    public static String decryption(String input) {
        //Insert your code here

        String[] words = input.split("\\W");// check empty

        HashMap<Integer, String> map = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            StringBuilder sb = new StringBuilder(word);
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    sum += Character.getNumericValue(sb.charAt(i));;
                    sb.deleteCharAt(i);
                }
            }

            map.put(sum, sb.toString());
        }
        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        StringBuilder result = new StringBuilder();
        for (String value : sortedMap.values()) {
            result.append(value).append(" ");
        }
        result.deleteCharAt(result.length()-1);

        return result.toString();
    }
}
