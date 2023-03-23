
/*
edit distance
*/

import java.util.*;
import java.io.*;

public class UVA10739 {
  static String str;
  static int dp[][];

  static int editDistance(int i, int j) {
    if (i >= j) return 0;
    if (dp[i][j] != -1) return dp[i][j];

    if (str.charAt(i) == str.charAt(j))
      return dp[i][j] = editDistance(i+1, j-1);
    else
      return dp[i][j] = 1 + Math.min(editDistance(i+1, j-1),
                            Math.min(editDistance(i+1, j),
                            editDistance(i, j-1)));
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    in.nextLine();
    dp = new int[1005][1005];

    for (int i=1; i<=t; i++) {
      str = in.nextLine();
      for (int row[] : dp)
        Arrays.fill(row, -1);
      System.out.println("Case " + i + ": " + editDistance(0, str.length()-1));
    }
  }
}
