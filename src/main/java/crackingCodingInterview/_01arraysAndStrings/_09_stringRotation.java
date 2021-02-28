package crackingCodingInterview._01arraysAndStrings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of" erbottlewat").
 * <p>
 * S:
 * s1 = xy = waterbottle
 * x = wat
 * y = erbottle
 * s2 = yx = erbottlewat
 * So, we need to check if there's a way to split s1 into x and y such that xy = s1 and yx = s2. Regardless of
 * where the division between x and y is, we can see that yx will always be a substring of xyxy.That is, s2 will
 * always be a substring of s1s1.
 * <p>
 * The runtime of this varies based on the runtime of isSubstring. But if you assume that isSubstring
 * runs in O(A+B) time (on strings of length A and B), then the runtime of is Rotation isO(N).
 */
public class _09_stringRotation {
    public static void main(String[] args) {

        String s1 = "waterbottle";
        String s2 = "rbottlewate";

        System.out.println(isRotation(s1, s2));
    }

    static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() > 0) {
            String concat = s1.concat(s1);
            return isSubstring(concat, s2);
        }
        return false;
    }

    private static boolean isSubstring(String concat, String s2) {
        return concat.contains(s2);
    }
}
