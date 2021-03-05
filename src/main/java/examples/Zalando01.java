package examples;

import java.util.Set;

public class Zalando01 {
    public static void main(String[] args) {
        System.out.println(solution("5055"));
    }

    public static int solution(String S) {
        if (S == null) {
            return 0;
        }

        int n = S.length();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            int twoDigit = Integer.parseInt(S.substring(i - 1, i + 1));
            if (twoDigit > max) {
                max = twoDigit;
            }
        }

        return max;

    }
}
