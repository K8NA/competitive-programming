/*
cube intersection
*/

import java.util.*;
import java.io.*;

public class UVA737 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int x, y, z, d;
    int xi, xj, yi, yj, zi, zj;

    while (t > 0) {
      x = in.nextInt(); xi = x;
      y = in.nextInt(); yi = y;
      z = in.nextInt(); zi = z;
      d = in.nextInt();
      xj = x + d;
      yj = y + d;
      zj = z + d;

      for (int i=1; i<t; i++) {
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();
        d = in.nextInt();
        xi = Math.max(x, xi);
        yi = Math.max(y, yi);
        zi = Math.max(z, zi);
        xj = Math.min(x+d, xj);
        yj = Math.min(y+d, yj);
        zj = Math.min(z+d, zj);
      }

      if (xi >= xj || yi >= yj || zi >= zj)
        System.out.println(0);
      else
        System.out.println((xj-xi) * (yj-yi) * (zj-zi));

      t = in.nextInt();

    }
  }
}
