
/*
0-1 Knapsack
*/

import java.util.*;
import java.io.*;

public class UVA10819 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      int m = in.nextInt(); // pocket money
      int n = in.nextInt(); // n of items

      int price[] = new int[n];
      int favor[] = new int[n];
      for (int i=0; i<n; i++) {
        price[i] = in.nextInt(); // price
        favor[i] = in.nextInt(); // favour level
      }

      int budget[] = new int[m+201];
      Arrays.fill(budget, Integer.MIN_VALUE);
      budget[0] = 0;

      for (int i=0; i<n; i++)
        for (int j=budget.length-1; j>=price[i]; j--)
          budget[j] = Math.max(budget[j], favor[i] + budget[j-price[i]]);

      int maxTotalFavor = 0;
      for (int i=0; i<=m; i++)
        maxTotalFavor = Math.max(maxTotalFavor, budget[i]);
      for (int i=2001; i<=m+200; i++)
        maxTotalFavor = Math.max(maxTotalFavor, budget[i]);

      System.out.println(maxTotalFavor);
    }
  }
}
