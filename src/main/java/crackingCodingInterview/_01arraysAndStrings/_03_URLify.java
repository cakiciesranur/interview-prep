package crackingCodingInterview._01arraysAndStrings;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 */
public class _03_URLify {
    public static void main(String[] args) {

        System.out.println(urlify("Mr John Smith "));
        System.out.println(urlify2("Mr John Smith "));
    }

    //Mr%20John%20Smith
    private static String urlify2(String str) {
        StringBuilder result = new StringBuilder();
        String[] strings = str.split(" ");

        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
            if (i < strings.length - 1) {
                result.append("%20");
            }
        }

        return result.toString();
    }

    //Mr%20John%20Smith%20
    private static String urlify(String str) {
        char[] chars = str.toCharArray();

        StringBuilder result = new StringBuilder();
        boolean hasBlank = false;

        for (char c : chars) {
            if (c == ' ') {
                if (hasBlank) {
                    continue;
                } else {
                    hasBlank = true;
                    result.append("%20");
                }
            } else {
                result.append(c);
                hasBlank = false;
            }
        }
        return result.toString();
    }
}
