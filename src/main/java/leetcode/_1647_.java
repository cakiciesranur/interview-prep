package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1647_ {

    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)  + 1);
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (char c : map.keySet()) {
            int t = map.get(c);
            while (set.contains(t)) {
                t--;
                res++;
            }
            if (t != 0) {
                set.add(t);
            }
        }
        return res;
    }
}
