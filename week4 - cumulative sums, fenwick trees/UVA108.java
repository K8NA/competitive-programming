
/*
max sub rectangle, O(n4)
cumulative sums + kadane algorithm
*/

import java.util.*;
import java.io.*;

public class UVA108 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int rect[][] = new int[n+1][n+1];
    int cs[][]   = new int[n+1][n+1];

    for (int i=1; i<=n; i++) {
      for (int j=1; j<=n; j++) {
        rect[i][j] = in.nextInt();
        cs[i][j]   = rect[i][j] + cs[i-1][j] + cs[i][j-1] - cs[i-1][j-1];
      }
    }

    int maxSum = Integer.MIN_VALUE;
    for (int i=1; i<=n; i++)
      for (int j=1; j<=n; j++)
        for (int x=i+1; x<=n; x++)   // adjust top right corner
          for (int y=j+1; y<=n; y++) // adjust bottom right corner
            maxSum = Math.max(maxSum,
                     (cs[x][y] - cs[i-1][y] - cs[x][j-1] + cs[i-1][j-1]));

    System.out.println(maxSum);

  }
}
