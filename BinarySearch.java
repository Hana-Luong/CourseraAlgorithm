import java.util.Arrays;

public class BinarySearch {
    /*    In Java, a static method is a method that belongs to a class rather than an instance of a class.
        The method is accessible to every instance of a class, but methods defined in an instance are only
         able to be accessed by that object of a class.*/
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whilelist = In.readInts(args[0]);
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist)) ==-1)
            StdOut.println(key);
        }
    }
}


