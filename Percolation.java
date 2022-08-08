/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

//open: id[i] or matrix[j][k] == 0 or n*n + 1 or n*n + 2;
public class Percolation {

    private int size;
    private int[][] matrix;
    /*    Note that i is an index of id[] and j, k are indices of matrix[]
          Relationship: i = j*j + k + 1;    */
    private int countOpen;
    private UFWeightedQuickUnion ufWQU;
    private int virtual_top;
    private int virtual_bot;

    public Percolation(int n) {
        countOpen = 0;

        matrix = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                matrix[j][k] = 1;
            }
        }
        size = n;

        virtual_top = 0;
        virtual_bot = n * n + 1;

        ufWQU = new UFWeightedQuickUnion(n * n + 2);
    }

    public void showMatrix() {
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                StdOut.printf(matrix[j][k] + " ");
            }
            StdOut.println();
        }
        StdOut.printf("--------------------------------\n");
    }

    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            // Open the site
            matrix[row][col] = 0;
            countOpen++;

            // Try to connect to virtual sites
            int id = row * size + col + 1;
            if (row == 0) {
                ufWQU.union(virtual_top, id);
            }
            else if (row == size - 1) {
                ufWQU.union(id, virtual_bot);
            }
        }
    }

    // Step 5a: is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return (matrix[row][col] == 0);
    }

    /* A full site is an open site that can be connected to an open site
    in the top row via a chain of neighboring (left, right, up, down) open sites.*/
    public boolean isFull(int row, int col) {
        // i = j*j + k + 1;
        int id = row * size + col + 1;

        int upperRow = row - 1;
        if (upperRow >= 0) {
            if (isOpen(row, upperRow))
                ufWQU.union(id, (row - 1) * size + col + 1);
        }

        int rightCol = col + 1;
        if (rightCol <= size - 1) {
            if (isOpen(row, rightCol))
                ufWQU.union(id, row * size + (col + 1) + 1);
        }

        int lowerRow = row + 1;
        if (lowerRow <= size - 1) {
            if (isOpen(lowerRow, col))
                ufWQU.union(id, (row + 1) * size + col + 1);
        }
        int leftCol = col - 1;
        if (leftCol >= 0) {
            if (isOpen(row, leftCol))
                ufWQU.union(id, row * size + (col - 1) + 1);
        }

        if (ufWQU.connected(id, virtual_top)) {
            return true;
        }
        return false;
    }

    public boolean percolates(int row, int col) {
        if (isFull(row, col)) {
            int id = row * size + col + 1;
            if (ufWQU.connected(virtual_bot, id))
                return true;
        }
        return false;
    }

    public int numberOfOpenSites() {
        return countOpen;
    }


    public static void main(String[] args) {

        int n = StdIn.readInt();
        //some kind of exception here, if n <= 0; Later
        Percolation perc = new Percolation(n);
        perc.showMatrix();

        int p;
        int q;

        do {
            p = StdRandom.uniform(0, n);
            q = StdRandom.uniform(0, n);
            perc.open(p, q);
            StdOut.printf("open site(%d, %d), # open sites: %d\n",
                          p, q, perc.numberOfOpenSites());
            perc.showMatrix();
        } while (!perc.percolates(p, q));

        StdOut.print(
                "The system percolates after : " + perc.numberOfOpenSites() + " sites open.\n");
        double ratio;
        ratio = (double) perc.numberOfOpenSites() / (n * n);
        StdOut.printf("The ratio is: %.5f\n", ratio);
    }

}

