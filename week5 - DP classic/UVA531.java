/*
Longest Common Subsequence of words
*/

import java.util.*;
import java.io.*;

public class UVA531 {

  static int dp[][] = new int[105][105];
  static boolean visited[][] = new boolean[105][105];
  static int h[][] = new int[105][105];
  static String text1[] = new String[105];
  static String text2[] = new String[105];

  public static int LCS(int n, int m) {
    if (n<0 || m<0) return 0;
    if (visited[n][m]) return dp[n][m];
    if (text1[n].equals(text2[m])) {
      h[n][m] = 1;
      dp[n][m] = LCS(n-1, m-1)+1;
    } else {
      int left  = LCS(n-1, m);
      int right = LCS(n, m-1);
      if (left >= right) {
        h[n][m] = 2;
        dp[n][m] = left;
      } else {
        h[n][m] = 3;
        dp[n][m] = right;
      }
    }
    visited[n][m] = true;
    return dp[n][m];
  }

  public static int printResult(int n, int m) {
    if (n<0 || m<0) return 0;
    if (h[n][m] == 1) {
      int next = printResult(n-1, m-1);
      if (next > 0)
        System.out.print(" ");
      System.out.print(text1[n]);
      return next+1;
    } else if (h[n][m] == 2)
      return printResult(n-1, m);
    return printResult(n, m-1);
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int a=0;
    int b=0;

    while (in.hasNext()) {

      while (true) {
        text1[a] = in.next();
        if (text1[a].equals("#"))
          break;
        a++;
      }

      while (true) {
        text2[b] = in.next();
        if (text2[b].equals("#"))
          break;
        b++;
      }

      for (int i=0; i<105; i++) {
        Arrays.fill(visited[i], false);
        Arrays.fill(h[i], 0);
      }

      LCS(a-1, b-1);
      printResult(a-1, b-1);
      System.out.println();

      a = b = 0;

    }
  }
}
