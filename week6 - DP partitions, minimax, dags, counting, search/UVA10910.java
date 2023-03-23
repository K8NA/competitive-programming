/*
DP counting
*/

import java.util.*;
import java.io.*;

public class UVA10910 {
  static int n, t, p;
  static int dp[][];

  static void calc() {
    dp = new int[n][t+1];
    for (int j=p; j<=t; j++)
      dp[0][j] = 1;
    for (int i=1; i<n; i++)
      for (int j=(i+1)*p; j<=t; j++)
        for (int k=p; j-k>=0; k++)
          dp[i][j] += dp[i-1][j-k];
  }

  public static void main(String args[]) throws IOException {
    Scanner in = new Scanner(System.in);

    int c = in.nextInt();
    for (int i=0; i<c; i++) {
      n = in.nextInt(); // n of subjects
      t = in.nextInt(); // n of marks total
      p = in.nextInt(); // min passing mark
      calc();
      System.out.println(dp[n-1][t]);
    }
  }
}
