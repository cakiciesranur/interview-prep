package crackingCodingInterview._01arraysAndStrings;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, pales ->true
 * pale, bale -> true
 * pale, bake -> false
 */
public class _05_oneWay {

    public static void main(String[] args) {
        System.out.println(hasOneWay("pale","ple"));
        System.out.println(hasOneWay("pales","pale"));
        System.out.println(hasOneWay("pale","pales"));
        System.out.println(hasOneWay("pale","bale"));
        System.out.println(hasOneWay("pale","bake"));
        System.out.println(hasOneWay("pale","pa"));
        System.out.println(hasOneWay("pale","pal"));
    }

    private static boolean hasOneWay(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        boolean needChanges = false;
        if (a.length() > b.length()) {
            for (int i = 0; i < b.length() - 1; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (needChanges) {
                        return false;
                    }
                    needChanges = true;
                }
            }
        } else {
            for (int i = 0; i < a.length() - 1; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (needChanges) {
                        return false;
                    }
                    needChanges = true;
                }
            }
        }

        return true;
    }
}
