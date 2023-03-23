import java.util.*;
import java.io.*;

public class CF4A {

  static void divide (int kilos) {
    System.out.println((kilos%2 == 0) && (kilos != 2) ? "YES" : "NO");
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    int w = in.nextInt();
    divide(w);
  }
}
