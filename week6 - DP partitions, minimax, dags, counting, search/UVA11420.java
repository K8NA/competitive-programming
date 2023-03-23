/*
DP counting - non "trivial" state
*/

import java.util.*;
import java.io.*;

public class UVA11420 {
  static int n;
  static Long s;
  static Long memo[][][];

  static long dp(int i, int secured, int sum) {
    if (i == n) {
      if (sum == s)
        return 1;
      return 0;
    }
    if (memo[i][secured][sum] != null)
      return memo[i][secured][sum];
    long ans = 0;
    if (secured == 1)
      ans += dp(i+1, 1, sum+1);
    else
      ans += dp(i+1, 1, sum);

    ans += dp(i+1, 0, sum);

    return memo[i][secured][sum] = ans;
  }

  public static void main(String args[]) throws NumberFormatException, IOException {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    while ((n = in.nextInt()) >= 0 && (s = in.nextLong()) >= 0) {
      memo = new Long[n][2][n+1];
      out.println(dp(0, 1, 0));
    }
    out.close();
  }
}
