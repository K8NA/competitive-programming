
// https://www.programiz.com/dsa/binary-search
// complexity - O(nlog(n))

import java.util.*;
import java.io.*;

public class TRIGALGE {

  final static double eps = 0.000000001;

  public static void main(String args[]) {
      Scanner in = new Scanner(System.in);

      int t = in.nextInt();

      for (int i=0; i<t; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        double low = 0;
        double high = c; // because x can't be bigger than c
        double mid = low + (high - low) / 2.0;

        while (high-low >= eps) {
          mid = low + (high - low) / 2.0;
          double ans = a*mid + b*(Math.sin(mid));
          if (ans >= c)
            high = mid;
          else
            low = mid;
        }
        System.out.format("%.6f", mid);
        System.out.println();
      }

  }
}
