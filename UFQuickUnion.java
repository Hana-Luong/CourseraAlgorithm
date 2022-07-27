import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
public class UFQuickUnion {
    private int[] id;
    private int count; // number of components

    public UFQuickUnion(int N) { // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    private int root(int i) {       //chase parent pointers until reach root
        //root is the value (REVERSED PICTURE)
        while (i != id[i])
            i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {    //check if p and q have same root
        // (depth of p and q array accesses)
        return root(p) == root(q);
    }

   /* private int find(int p) { // Find component name.//similar to root()
        while (p != id[p])
            p = id[p];
        return p;
    }*/

    public void union(int p, int q) {   //change root of p to point to root of q
        //(depth of p and q array accesses)
        int i = root(p);
        int j = root(q);
        id[i] = j;
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
