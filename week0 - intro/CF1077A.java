import java.util.*;
import java.io.*;

public class CF1077A {

  static long finalPos(int odd, int even, int nJumps) {
    if (nJumps % 2 == 0)
      return (long)odd * nJumps/2 - (long)even * nJumps/2;
    else
      return odd + finalPos(odd, even, nJumps-1);
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i=0; i<t; i++) {
      int odd = in.nextInt();  // jump to the right
      int even = in.nextInt(); // jump to the left
      int n = in.nextInt();
      long finalP = finalPos(odd, even, n);
      System.out.println(finalP);
    }
  }
}
