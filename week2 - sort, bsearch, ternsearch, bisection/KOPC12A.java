// https://www.tutorialspoint.com/Ternary-Search?key=ternary+search+java
// https://www.spoj.com/problems/KOPC12A/en/

/*
complexity - O(nlogn)
idea: find the optimal cost through ternary search
using longs everywhere
*/


import java.util.*;
import java.io.*;

public class KOPC12A {

  static long optCost (long height, int n, long h[], long c[]) {
    long opt = 0;
    for (int i=0; i<n; i++)
      opt += Math.max(0, Math.abs(height - h[i]) * c[i]); // accumulate cost per buliding
    return opt;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    for (int i=0; i<t; i++) {
      int n = in.nextInt();

      long heights[] = new long[n];
      for (int j=0; j<n; j++)
        heights[j] = in.nextInt();

      long costs[] = new long[n];
      for (int k=0; k<n; k++)
        costs[k] = in.nextInt();

      // ternary search:
      long low=0, high=1000000;
      while (low < high) {
        long mid1 = low + (high - low) / 3;
        long mid2 = high - (high - low) / 3;

        long optMid1 = optCost(mid1, n, heights, costs);
        long optMid2 = optCost(mid2, n, heights, costs);

        if (optMid1 > optMid2)
          low = mid1 + 1;
        else
          high = mid2 - 1;
      }

      System.out.println(optCost(low, n, heights, costs)); // find the min cost for the lowest value

    }

  }
}
