/*
DP partitions
*/

import java.util.*;
import java.io.*;

public class UVA11258 {

  static final int LIM = 2147483647;
  static int n;
  static String str;
  static long memo[];

  static long dp(int i, long sum) {
    if (i == n+1) return sum;
    if (memo[i] != -1) return memo[i];

    int len = Math.min(n-i, 11);
    long max = 0;

    for (int j=i+1; j<=i+len; j++) {
      long aux = Long.parseLong(str.substring(i, j));
      boolean appr = true;
      if (appr && aux <= LIM) {
        long dp = dp(j, sum+aux);
        max = Math.max(max, dp+aux);
      } else
        appr = false;
    }
    return memo[i] = max;
  }

  public static void main(String args[]) throws IOException {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    memo = new long[205];
    int t = in.nextInt();

    for (int c=0; c<t; c++) {
      Arrays.fill(memo, -1);
      str = in.next();
      n = str.length();
      System.out.println(dp(0, 0));
    }
  }
}
