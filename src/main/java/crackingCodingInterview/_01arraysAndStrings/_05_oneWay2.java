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
public class _05_oneWay2 {

    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pale"));
        System.out.println(oneEditAway("pale", "pales"));
        System.out.println(oneEditAway("pale", "bale"));
        System.out.println(oneEditAway("pale", "bake"));
        System.out.println(oneEditAway("pale", "pa"));
        System.out.println(oneEditAway("pale", "pal"));
    }

    static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    static boolean oneEditReplace(String sl, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < sl.length(); i++) {
            if (sl.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }

        }
        return true;
    }

    /* Check if you can insert a character into sl to make s2. */
    static boolean oneEditInsert(String sl, String s2) {
        int indexl = 0;
        int index2 = 0;
        while (index2 < s2.length() && indexl < sl.length()) {
            if (sl.charAt(indexl) != s2.charAt(index2)) {
                if (indexl != index2) {
                    return false;
                }
                index2++;
            } else {
                indexl++;
                index2++;
            }
        }
        return true;
    }
}