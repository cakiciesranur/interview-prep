package CodilityZalando;

/**
 * An array A consisting of N integers is given. The elements of array A together represent a chain, and each element represents the strength of each link in the chain. We want to divide this chain into three smaller chains.
 * All we can do is to break the chain in exactly two non-adjacent positions. More precisely, we should break links P, Q (0 < P < Q < N − 1, Q − P > 1), resulting in three chains [0, P − 1], [P + 1, Q − 1], [Q + 1, N − 1]. The total cost of this operation is equal to A[P] + A[Q].
 * For example, consider array A such that:
 * A[0] = 5
 * A[1] = 2
 * A[2] = 4
 * A[3] = 6
 * A[4] = 3
 * A[5] = 7
 * We can choose to break the following links:
 * (1, 3): total cost is 2 + 6 = 8
 * (1, 4): total cost is 2 + 3 = 5
 * (2, 4): total cost is 4 + 3 = 7
 * Write a function:
 * that, given an array A of N integers, returns the minimal cost of dividing chain into three pieces.
 * A[0] = 5
 * A[1] = 2
 * A[2] = 4
 * A[3] = 6
 * A[4] = 3
 * A[5] = 7
 */

public class Zalando02 {
    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 3, 7};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if (A.length <= 2) return 0;

        int firstMin;
        int secondMin;
        int cost = Integer.MAX_VALUE;

        for (int i = 1; i < A.length - 1; i++) {
            firstMin = A[i];
            for (int j = i + 2; j < A.length - 1; j++) {
                secondMin = A[j];
                if (secondMin + firstMin < cost) {
                    cost = secondMin + firstMin;
                }
            }

        }
        return cost;
    }
}
