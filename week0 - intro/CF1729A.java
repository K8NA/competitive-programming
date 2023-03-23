import java.util.*;
import java.io.*;

public class CF1729A {

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i=0; i<t; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      int ans = -1;
      if (b > c) {
        if (a == b)
          ans = 3;
        else
          ans = a < b ? 1 : 2;
      } else {
        if (a == (2 * c-b))
          ans = 3;
        else
          ans = a < (2 * c-b) ? 1 : 2;
      }
      System.out.println(ans);
    }
  }
}
