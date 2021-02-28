package crackingCodingInterview._08_dynamicProgramming;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class _01_tripleStep {
    //brute force
    //Like the Fibonacci problem, the runtime of this algorithm is exponential (roughly O ( 3") ), since each call
    //branches out to three more calls.
    int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }
}
