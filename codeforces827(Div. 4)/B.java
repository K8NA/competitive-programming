

import java.util.*;
import java.io.*;

public class B {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    for (int i=0; i<t; i++) {
      int n = in.nextInt();
      int elem[] = new int[n];
      for (int j=0; j<n; j++)
        elem[j] = in.nextInt();

      Arrays.sort(elem);

      // System.out.println();
      // for (int j=0; j<n; j++)
      //   System.out.print(elem[j] + " ");

      int f = 0;
      if (n > 1) {
        for (int k=0; k<n-1; k++) {
          if (elem[k] == elem[k+1]) {
            f = 0;
            break;
          } else f = 1;
        }
      } else if (n == 1) f = 1;

      if (f == 1)
        System.out.println("YES");
      else
        System.out.println("NO");

    }
  }
}
