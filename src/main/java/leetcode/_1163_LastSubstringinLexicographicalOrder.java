package leetcode;

/**
 * Given a string s, return the last substring of s in lexicographical order.
 * Example 1:
 * Input: s = "abab"
 * Output: "bab"
 * Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
 * Example 2:
 * Input: s = "leetcode"
 * Output: "tcode"
 */
public class _1163_LastSubstringinLexicographicalOrder {
    public static void main(String[] args) {
        System.out.println(lastSubstring("abab"));
    }

    /**
     * 1) in lexicographical order the smaller string is always considered shorter
     * 2) This means that suppose if we have a solution substring
     * s.substring(i , j)
     * as largest substring  then we can always find a better solution by increasing its length to the end
     * i.e s.substring(i, n) is the better solution
     * From this we conclued the all possible solution are just suffixes
     * 3) Now to generate suffix is just O(n)  and we can compare all the suffixes
     * 4) Optimisation 1
     * a. Find the character which is highest in string - say Z
     * b. Only compare the suffixes that start with Z
     * 5) Optimisation 2
     * a. If prev and curr character are same , skip this because of length
     * e.g. bbxya  >  bxya
     */
    public static String lastSubstring(String s) {
        //find biggest character
        int max = s.charAt(0);
        for (char c : s.toCharArray()) {
            max = c > max ? c : max;
        }

        String res = s.substring(0);
        for (int i = 0; i < s.length(); i++) {

            //skip if pre character is same
            if (i > 0) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    continue;
                }
            }

            //check if suffix starts with max charcter
            if (s.charAt(i) == max) {
                String curr = s.substring(i);

                if (curr.compareTo(res) > 0) {
                    res = curr;
                }
            }
        }
        return res;
    }
}
