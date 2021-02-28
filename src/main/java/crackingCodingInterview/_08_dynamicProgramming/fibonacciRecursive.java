package crackingCodingInterview._08_dynamicProgramming;

public class fibonacciRecursive {
    //0( 2") n over 2
    int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
