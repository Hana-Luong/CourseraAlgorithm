/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class BasicFunctions {
    public static double findMax(double a[]) {
        double max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    public static double findAverage(double a[]) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        double average = sum / a.length;
        return average;
    }

    public static void copyArray(double a[]) {
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = a[i];
            System.out.print(b[i] + " ");
        }

        System.out.println(" ");
    }

    public static void reverseElement(double a[]) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            double temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - i - 1] = temp;
        }
        for (int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println(" ");
    }

    public static void main(String[] args) {
        double a[] = { 1.2, 1.1, 15.7, 18.0 };
        System.out.println("The max value is " + findMax(a));
        System.out.println("The average of array elements is: " + findAverage(a));
        copyArray(a);
        reverseElement(a);
    }
}

