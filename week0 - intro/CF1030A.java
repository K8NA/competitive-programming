import java.util.*;
import java.io.*;

public class CF1030A {

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int f = 0;
    for (int i=0; i<n; i++) {
      int easy = in.nextInt();
      if (easy != 0) {
        f = 1;
        break;
      }
    }
    if (f == 0)
      System.out.println("EASY");
    else
      System.out.println("HARD");
  }
}
