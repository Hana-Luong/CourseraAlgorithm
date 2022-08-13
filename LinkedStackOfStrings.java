/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStackOfStrings {

    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node first = null;
    private int n;                // size of the stack

    public LinkedStackOfStrings() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(String item) {
        Node oldfirst = first;
        first = new Node("first");
        first.item = item;
        first.next = oldfirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedStackOfStrings linkedStack = new LinkedStackOfStrings();
        //StdOut.printf("StackOfStrings\n");
        while (1 == 1) {
            String s = StdIn.readString();
            //StdOut.printf("Your input: '%s'\n", s);
            if (s.contentEquals("exit"))
                break;

            if (s.equals("-"))
                StdOut.print(linkedStack.pop());
            else
                linkedStack.push(s);
        }

    }

}
