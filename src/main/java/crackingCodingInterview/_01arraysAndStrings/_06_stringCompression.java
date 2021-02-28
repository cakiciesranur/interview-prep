package crackingCodingInterview._01arraysAndStrings;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class _06_stringCompression {

    public static void main(String[] args) {

        System.out.println(stringCompression("aabcccccaaa"));
    }

    private static String stringCompression(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int length = s.toCharArray().length;

        for (int i = 0; i < length; i++) {
            count++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                result.append(s.charAt(i));
                result.append(count);
                count = 0;
            }
        }

        return result.length() < length ? result.toString() : s;
    }
}