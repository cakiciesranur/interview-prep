package CodilityMicrosoft;

import java.util.stream.IntStream;

/**
 * 2 frogs can start on any index in the given input_array. The function should return the maximum possible distance these frogs can create between them (difference between the index values of both) by having them jump farther away from each other.
 * Frogs can only jump on higher value elements or some of the same height and they can not skip any elements.
 * Input: [1, 5, 5, 2, 6]
 * Output: 3. Largest distance of 3 is created by having spawn location 3 (0-indexed) and left frog jump until index 1 and right frog jumps until index 4.
 * len(input_array) is between 2 and 200 000. Values in array are integers between 1 and 1 000 000 000.
 */
public class Microsoft03 {
    public static void main(String[] args) {

    }

    public int solution(int[] blocks) {
        final int numBlocks = blocks.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < blocks.length; i++) {
            int leftSum = 0;
            if (i != 0) {
                int leftPos = i;
                while (leftPos - 1 >= 0 && blocks[leftPos - 1] >= blocks[leftPos]) {
                    leftSum++;
                    leftPos--;
                }
            }

            int rightSum = 0;
            int rightPos = i;
            while (rightPos + 1 < numBlocks && blocks[rightPos + 1] >= blocks[rightPos]) {
                rightSum++;
                rightPos++;
            }

            int currentDistance = rightSum + leftSum;

            if (currentDistance > max) {
                max = currentDistance;
            }

        }

        return max;

    }

    public int findMaxDistance(int[] blocks) {
        final int numBlocks = blocks.length;

        return IntStream.range(0, blocks.length)
                .parallel()
                .map(i -> {
                            int leftSum = 0;
                            if (i != 0) {
                                int leftPos = i;
                                while (leftPos - 1 >= 0 && blocks[leftPos - 1] >= blocks[leftPos]) {
                                    leftSum++;
                                    leftPos--;
                                }
                            }

                            int rightSum = 0;
                            int rightPos = i;
                            while (rightPos + 1 < numBlocks && blocks[rightPos + 1] >= blocks[rightPos]) {
                                rightSum++;
                                rightPos++;
                            }


                            return rightSum + leftSum;
                        }
                )
                .max().getAsInt();

    }
}
