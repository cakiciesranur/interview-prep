package leetcode;

import java.util.Stack;

/**
 * You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
 * At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
 * An integer x - Record a new score of x.
 * "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
 * "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
 * "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
 * Return the sum of all the scores on the record.
 */
public class _682_baseballGame {

    public static void main(String[] args) {

        String[] arr ={"5","2","C","D","+"};
        System.out.println(calPoints(arr));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> score = new Stack<>();

        for (String op : ops) {
            int newScore;
            if (op.equalsIgnoreCase("D")) {
                newScore = score.peek() * 2;
                score.push(newScore);
            } else if (op.equalsIgnoreCase("C")) {
                score.pop();
            } else if (op.equalsIgnoreCase("+")) {
                newScore = score.peek() + score.get(score.size() - 2);
                score.push(newScore);
            } else {
                newScore=Integer.valueOf(op);
                score.push(newScore);
            }
        }

        int sum = 0;
        while (!score.isEmpty()) {
            sum += score.pop();
        }
        return sum;
    }
}
