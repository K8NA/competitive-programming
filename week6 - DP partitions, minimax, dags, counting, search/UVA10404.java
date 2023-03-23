/*
DP minimax principle
Bachet's game
*/

import java.util.*;
import java.io.*;

public class UVA10404 {

  public static void main(String args[]) throws IOException {
    Scanner in = new Scanner(System.in);

    final int MAX = 1000010;
    int stone[] = new int[15];
    int dp[] = new int[MAX];

    while (in.hasNext()) {
      int sum = in.nextInt();
      int n = in.nextInt();
      for (int i=0; i<n; i++)
        stone[i] = in.nextInt();
      for (int i=0; i<MAX; i++)
        dp[i] = 0;
      for (int i=0; i<=sum; i++)
        for (int j=0; j<n; j++)
          if (i>= stone[j] && dp[i-stone[j]] == 0) {
            dp[i] = 1;
            break;
          }
      if (dp[sum] == 1)
        System.out.println("Stan wins");
      else
        System.out.println("Ollie wins");
    }
  }
}
