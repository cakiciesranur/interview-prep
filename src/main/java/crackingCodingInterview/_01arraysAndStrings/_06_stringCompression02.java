package crackingCodingInterview._01arraysAndStrings;

/**
 * One other benefit of this approach is that we can initialize StringBuilder to its necessary capacity
 * up-front. Without this, StringBuilder will (behind the scenes) need to double its capacity every time it
 * hits capacity. The capacity could be double what we ultimately need.
 */
public class _06_stringCompression02 {
    public static void main(String[] args) {

    }

    static String compress(String str) {
        /* Check final length and return input string if it would be longer. */
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    static int countCompression(String str) {
        int compressedlength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, increase the length.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedlength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedlength;
    }
}
