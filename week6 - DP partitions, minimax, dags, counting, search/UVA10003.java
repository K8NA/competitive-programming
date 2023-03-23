
/*
DP in search with memoization
*/

import java.util.*;
import java.io.*;

public class UVA10003 {

  static int memo[][];
  static int cuts[];

  static int dp(int i, int j) {
    if (i+1 == j) return 0;
    if (memo[i][j] != -1) return memo[i][j];
    int minCost = Integer.MAX_VALUE;
    for (int k=i+1; k<j; k++)
      minCost = Math.min(minCost, dp(i, k) + dp(k, j)
                                  + cuts[j] - cuts[i]);
    return memo[i][j] = minCost;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    while (true) {
      int l = in.nextInt(); // length of the stick
      if (l == 0) break;
      int n = in.nextInt(); // n of cuts

      memo = new int[n+2][n+2];
      for (int row[] : memo)
        Arrays.fill(row, -1);

      cuts = new int[n+2];
      cuts[0] = 0;
      cuts[n+1] = l;
      for (int i=1; i<=n; i++)
        cuts[i] = in.nextInt();

      System.out.println("The minimum cutting is " + dp(0, n+1) + ".");
    }
  }
}
