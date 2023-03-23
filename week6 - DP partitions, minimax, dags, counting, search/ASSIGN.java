/*
DP with bitmasks
https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
*/

import java.util.*;
import java.io.*;

public class ASSIGN {

  static int n;
  static long memo[];
  static boolean pref[][];

  static long assign(int i, int mask) {
    if (i == n)
      return mask == 0 ? 1 : 0;
    if (memo[mask] != -1)
      return memo[mask];
    long difAss = 0;
    for (int j=0; j<n; j++)
      if (pref[i][j] && (mask & (1 << j)) > 0)
        difAss += assign(i+1, mask ^ (1 << j));

    return memo[mask] = difAss;
  }

  public static void main(String args[]) throws IOException {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int t = in.nextInt();

    for (int c=0; c<t; c++) {
      n = in.nextInt(); // n of students
      pref = new boolean[n][n];
      memo = new long[1 << n];
      for (int i=0; i<n; i++)
        for (int j=0; j<n; j++)
          pref[i][j] = in.nextInt() == 1;

      Arrays.fill(memo, -1);
      out.println(assign(0, (1 << n)-1));
    }
    out.close();
  }
}
