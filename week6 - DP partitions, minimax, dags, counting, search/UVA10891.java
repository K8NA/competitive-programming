
/*
DP minimax game of sum
*/

import java.util.*;
import java.io.*;

public class UVA10891 {

  static int dp[][] = new int[101][101];
  static int sum[] = new int[101];
  static boolean visited[][] = new boolean[101][101];

  static int dp(int i, int j) {
    if (visited[i][j]) return dp[i][j];
    visited[i][j] = true;
    int min = 0;
    for (int k=i+1; k<=j; k++)
      min = Math.min(min, dp(k, j));
    for (int k=i; k<j; k++)
      min = Math.min(min, dp(i, k));
    dp[i][j] = sum[j] - sum[i-1] - min;
    return dp[i][j];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    while (true) {
      int n = in.nextInt(); // n of elements
      if (n == 0) break;
      Arrays.fill(visited[0], false);
      sum[0] = 0;
      for (int i=1; i<=n; i++) {
       sum[i] = sum[i-1] + in.nextInt();
       Arrays.fill(visited[i], false);
      }
      System.out.println(2 * dp(1, n) - sum[n]);
    }
  }
}
