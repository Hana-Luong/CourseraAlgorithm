/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFQuickUnionRedo {

    private int[] id;
    private int count;

    public UFQuickUnionRedo(int N) { // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    //check if p and q have same root
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];      //Not upside-down tree; this is the key to success;
        return i;
    }

    //change root of p TO POINT TO root of q
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
        count--;
    }

    public int count() {
        return count;
    }

    public void printSites(int N) {
        System.out.print("The indices are: ");
        for (int i = 0; i < N; i++) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.print("The ids are:     ");
        for (int i = 0; i < N; i++) {
            System.out.print(id[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {

        int N = StdIn.readInt();
        UFQuickUnionRedo qu = new UFQuickUnionRedo(N);

        int p = 0, q = 0;
        while (1 == 1) {
            p = StdIn.readInt();
            if (p == -1)
                break;
            q = StdIn.readInt();
            if (q == -1)
                break;
            if (qu.connected(p, q))
                continue;
            qu.union(p, q);
            StdOut.println(p + " " + q + " are now connected");
        }
        qu.printSites(N);
        System.out.println("");
        StdOut.println(qu.count() + " components");
    }
}
