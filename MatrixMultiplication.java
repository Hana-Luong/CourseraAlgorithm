/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
//REVIEW LATER
public class MatrixMultiplication {
    public static void main(String[] args) {

        int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int b[][] = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int n = a.length;

        int c[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)     //Compute dot product of row i and column j
            {
                for (int k = 0; k < n; k++) //k deals with each term
                    c[i][j] += a[i][k] * b[k][j];
                System.out.print(c[i][j] + " ");  //printing matrix element
            }//end of j loop
            System.out.println();
        }
    }
}
