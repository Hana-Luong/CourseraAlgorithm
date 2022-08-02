import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFWeightedQUwPathCompression {

    private int[] id; // original array
    private int[] sz; // size of (each) component for roots
    private int count; // number of components

    public UFWeightedQUwPathCompression(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;

        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = findRoot(p);
        int j = findRoot(q);
        if (i == j)
            return;

        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) {        //compare two array sizes
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
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
        UFWeightedQUwPathCompression wqupc = new UFWeightedQUwPathCompression(N);
        int p = 0, q = 0;

        while (1 == 1) {
            p = StdIn.readInt();
            if (p == -1)
                break;
            q = StdIn.readInt();
            if (q == -1)
                break;
            if (wqupc.connected(p, q))
                continue; // Ignore if connected.
            wqupc.union(p, q);
            StdOut.println(p + " and " + q + " are now connected"); // and print connection.
        }
        wqupc.printSites(N);
        System.out.println("");
        StdOut.println(wqupc.count() + " components");
    }
}


