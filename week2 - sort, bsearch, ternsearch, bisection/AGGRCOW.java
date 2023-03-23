
/*
https://leetcode.com/discuss/general-discussion/1302335/aggressive-cows-spoj-fully-explained-c
complexity - O(nlog(n))
idea:
sort the array of stalls, binary search the x where
low and high are the starting and ending positions of the stalls,
mid is the minimum distance between each cow
(found by greedy checking if it's possible to place a cow so that
it's at least x stalls away from the last placed cow,
starting at the leftmost stall)
*/

import java.util.*;
import java.io.*;

public class AGGRCOW {

  public static boolean possibleDist (int v[], int minDist, int k) {
    int cows = 1;
    int lastCow = v[0]; // greedy algorithm for placing each cow at leftmost stall
    for (int i=1; i<v.length; i++) {
      if (v[i]-lastCow >= minDist) { // lower-current >= mid
        cows++; // possible positions
        lastCow = v[i]; //System.out.println(v[i]);
        if (cows >= k) return true; // possible solution
      }
    }
    return false;
  }

  public static void main(String args[]) {
      Scanner in = new Scanner(System.in);

      int t = in.nextInt();

      for (int i=0; i<t; i++) {
        int n = in.nextInt();
        int c = in.nextInt();

        int stalls[] = new int[n];

        for (int j=0; j<n; j++)
          stalls[j] = in.nextInt();

        int size = stalls.length;
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[size-1]-stalls[0];
        int ans = 0; // largest minimum distance

        while (low <= high) {
          int mid = low + (high - low) / 2;
          if (possibleDist(stalls, mid, c)) {
            ans = mid; // store the solution
            low = mid + 1; // increase the minDist
          } else high = mid - 1; // move onto next solution
        }
        System.out.println(ans);
      }
  }
}
