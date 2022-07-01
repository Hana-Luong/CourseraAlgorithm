/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFWeightedQU {

    private int[] id; // parent link (site indexed)//original array
    private int[] sz; // size of (each) component for roots (site indexed)
    private int count; // number of components

    public UFWeightedQU(int N) {
        count = N;
        id = new int[N];            //Line 9?
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];            //Line 10?
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) { // Follow links to find a root.
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return; //?
        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) {        //compare two array
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
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

    public static void main(String[] args) { // Solve dynamic connectivity problem on StdIn.
        int N = StdIn.readInt(); // Read number of sites.
        UFQuickUnion uf = new UFQuickUnion(N); // Initialize N components.
        int p = 0, q = 0;
        while (1 == 1) {
            p = StdIn.readInt();
            if (p == -1)
                break;
            q = StdIn.readInt();
            if (q == -1)
                break; // Read pair to connect.
            if (uf.connected(p, q))
                continue; // Ignore if connected.
            uf.union(p, q); // Combine components
            StdOut.println("p and q are: " + p + " " + q); // and print connection.
        }
        uf.printSites(N);
        System.out.println("");
        StdOut.println(uf.count() + " components");
    }
}

