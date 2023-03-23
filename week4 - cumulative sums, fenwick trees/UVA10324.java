
/*
ones and zeroes
*/

import java.util.*;
import java.io.*;

public class UVA10324 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int cases = 1;

    while (in.hasNext()) {
      char array[] = in.next().toCharArray();
      int v[] = new int[array.length];
      if (array[0] == '0')
        v[0] = 0;
      else
        v[0] = 1;
      for (int i=1; i<array.length; i++) {
        if (array[i] == '0')
          v[i] = v[i-1];
        else
          v[i] = v[i-1] + 1;
      }
      int n = in.nextInt(); // queries for this case
      System.out.println("Case " + cases + ":");
      cases++;
      while (n-- > 0) {
        int i = in.nextInt();
        int j = in.nextInt();
        int x = Math.min(i,j);
        int y = Math.max(i,j);
        boolean eq = true;
        for (int a=x; a<=y; a++) {
          if (array[a] != array[i]) {
            eq = false;
            break;
          }
        }
        System.out.println(eq ? "Yes" : "No");
      }
    }
  }
}
