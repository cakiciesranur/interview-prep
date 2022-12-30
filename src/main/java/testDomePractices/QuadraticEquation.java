package testDomePractices;
/*
* Implement the function findRoots to find the roots of the quadratic equation: ax2 + bx + c = 0.
* The function should return a Roots object containing roots in any order.
* If the equation has only one solution, the function should return that solution as both elements of the Roots.
* The equation will always have at least one solution.

The roots of the quadratic equation can be found with the following formula:
* x = [-b ± √(b2 - 4ac)]/2a.

For example, findRoots(2, 10, 8) should return a Roots object
* where either x1 = -1, x2 = -4 or x1 = -4, x2 = -1 as the roots of the equation 2x2 + 10x + 8 = 0 are -1 and -4.
* */
public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        double x1 =((-b + Math.sqrt ( b*b - 4*a*c))/(2*a));
        double x2 =((-b - Math.sqrt ( b*b - 4*a*c))/(2*a));
        return new Roots(x1, x2);
    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}