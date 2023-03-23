import java.util.*;
import java.io.*;

public class C {

  static final int length = 8;
  static final char red = 'R';
  static final char blue = 'B';

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    for (int k=0; k<t; k++) {

      char grid[][] = new char[length][length];
      for (int i=0; i<length; i++) {
        String buf = in.next();
        for (int j=0; j<length; j++)
          grid[i][j] = buf.charAt(j);
      }

      int r=0, b=0, f=0;

      for (int i=0; i<length; i++) {
        r=0;
        for (int j=0; j<length; j++) {
          if (grid[i][j] == red)
            r++;
        }
        if (r == 8) {
          System.out.println(red);
          f = 1;
          break;
        }
      }

      if (f == 0)
        System.out.println(blue);

    }
  }
}
