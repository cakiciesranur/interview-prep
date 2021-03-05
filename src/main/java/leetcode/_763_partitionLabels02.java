package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class _763_partitionLabels02 {
    public static void main(String[] args) {
        //String S = "ababcbacadefegdehijhklij";
        String S = "caedbdedda";
        partitionLabels(S).stream().forEach(System.out::println);
    }

    public static List<Integer> partitionLabels(String S) {
        int[] lastIndexes = new int[26];
        for(int i = 0; i<S.length(); i++){
            lastIndexes[S.charAt(i) - 'a'] = i;
        }

        List<Integer> partitionLengths = new ArrayList<>();
        int i= 0;

        while(i<S.length()){
            int end = lastIndexes[S.charAt(i)-'a'];
            int j = i;
            while(j != end){
                end = Math.max(end, lastIndexes[S.charAt(j++)- 'a']);

            }

            partitionLengths.add(j-i+1);
            i = j+1;
        }

        return partitionLengths;
    }
}
