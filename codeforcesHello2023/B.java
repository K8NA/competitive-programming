import java.io.*;
import java.util.*;
import java.util.stream.*;

public class B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for (int i=0; i<t; i++) {
      int n = in.nextInt();
      if (n%2 == 0) {
        System.out.println("YES");
        for (int j=0; j<n/2; j++)
            System.out.print("1 -1 ");
        System.out.println();
      } else if (n == 3) {
        System.out.println("NO");
      } else {
          System.out.println("YES");
          int x = n/2;
          for (int j=0; j<n/2; j++)
            System.out.print(1-x + " " + x + " ");
          System.out.println(1-x);
      }
    }
  }
}
