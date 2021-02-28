package examples;

/**
 * Maximum sum of two elements whose digit sum is equal
 */
public class BreakChainZalando2 {
    public static void main(String[] args) {

    }

    public static int solution(int[] A) {

        int firstIndex = 0;
        int firstMinCost = Integer.MAX_VALUE;
        int secondIndex = 0;
        int secondMinCost = Integer.MAX_VALUE;

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] < firstMinCost) {
                firstMinCost = A[i];
                firstIndex = i;
            }
        }

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] < secondMinCost && i != firstIndex && Math.abs(firstIndex - i) > 1) {
                secondMinCost = A[i];
                secondIndex = i;
            }
        }

        return firstMinCost + secondMinCost;

    }

}
