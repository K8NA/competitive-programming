
import java.util.*;
import java.io.*;

public class UVA100 {

    public static int MAX = 10000;
    public static int[] cache = new int[MAX];

    public static int cycleLength (int n) {
      if (n==1) return 1;
      if (n < MAX && cache[(int)n] != 0) return cache[(int)n];

      int length = 1 + cycleLength(nextCycle(n));
      if (n < MAX)
        cache[(int)n] = length;
      return length;
    }

    public static int nextCycle (int n) {
      if (n % 2 == 0)
        return n/2;
      else return n*3+1;
    }

    public static void main(String args[]) {
      Scanner in = new Scanner(System.in);

      while (in.hasNextInt()) {
        int i = in.nextInt();
        int j = in.nextInt();
        int max=0, min=0;
        if (i > j) {
          max = i; min = j;
        } else {
          max = j; min = i;
        }
        int maxCycleLength = 0;

        for (int k = min; k <= max; k++)
          maxCycleLength = Math.max(maxCycleLength, cycleLength (k));

        System.out.println(i + " " + j + " " + maxCycleLength);
      }

    }
}
