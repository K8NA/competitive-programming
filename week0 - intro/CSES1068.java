

import java.util.*;
import java.io.*;

public class CSES1068 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    long n = in.nextInt();

    while (n != 1) {
      System.out.print(n + " ");
      if (n % 2 == 0)
        n = n/2;
      else
        n = n*3+1;
    }
    System.out.println(n);
  }
}
