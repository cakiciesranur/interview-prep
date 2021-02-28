package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 * <p>
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 */
public class _68_textSatisfaction {
    public static void main(String[] args) {

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> wordList = new ArrayList<>();
        int index = 0;


        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                }
                totalChars = totalChars + 1 + words[last].length();
                last++;
            }

            int gaps = last - index - 1;
            StringBuilder wordLine = new StringBuilder();

            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    wordLine.append(words[i]);
                    wordLine.append(' ');
                }
                wordLine.deleteCharAt(wordLine.length() - 1);

                while (wordLine.length() < maxWidth) {
                    wordLine.append(' ');
                }
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;

                for (int i = index; i < last - 1; i++) {
                    wordLine.append(words[i]);
                    wordLine.append(' ');

                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {
                        wordLine.append(' ');
                    }
                }

                wordLine.append(words[last - 1]);
            }

            wordList.add(wordLine.toString());
            index = last;
        }
        return wordList;
    }
}
