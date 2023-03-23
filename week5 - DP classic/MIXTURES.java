
/*
Matrix Chain Multiplication
*/

import java.util.*;
import java.io.*;

public class MIXTURES {

  static long dp[][] = new long[201][101];
  static int mixtures[];

  static long MCM(int i, int j) {
    if (i >= j) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    dp[i][j] = Long.MAX_VALUE;

    for (int k=i; k<=j; k++)
      dp[i][j] = Math.min(dp[i][j], MCM(i, k) + MCM(k+1, j)
                          + cumulSum(i, k) * cumulSum(k+1, j));

    return dp[i][j]; // minimum cost to multiply the chain from ith matrix to jth matrix
  }

  static long cumulSum(int i, int j) {
    long sum = 0;
    for (int k=i; k<=j; k++) {
      sum += mixtures[k];
      sum %= 100;
    }
    return sum;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      int n = in.nextInt(); // n of mixtures
      mixtures = new int[n];
      for (int i=0; i<n; i++)
        mixtures[i] = in.nextInt();

      for (long row[] : dp)
        Arrays.fill(row, -1);

      long minSmoke = MCM(0, n-1);
      System.out.println(minSmoke);
    }
  }
}
