/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 * Write a program RandomWord.java that reads a sequence of words from standard
 * input and prints one of those words uniformly at random. Do not store the words
 * in an array or list. Instead, use Knuth’s method: when reading the ith word,
 *  select it with probability 1/i to be the champion, replacing the previous champion.
 *  After reading all of the words, print the surviving champion.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int i = 1;

        String champion = "first";
        String current_word = " ";

        while (!current_word.contentEquals("0")) {
            current_word = StdIn.readString();
            double p = (double) 1 / i;
            boolean result = StdRandom.bernoulli(p);//true or false
            if (result) {
                champion = current_word;
            }
            i++;
        }
        StdOut.println(champion);
    }
}



