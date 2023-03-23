import java.util.*;
import java.io.*;

public class Zamka {

  static int digitSum(int n) {
    int sum = 0;
    while (n != 0) {
      sum += n % 10;
      n = n/10;
    }
    return sum;
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    int l = in.nextInt();
    int d = in.nextInt();
    int x = in.nextInt();
    int n = 0;
    int m = 0;

    while (true) {
      n = digitSum(l);
      if (n == x)
        break;
      l++;
    }

    while (true) {
      m = digitSum(d);
      if (m == x)
        break;
      d--;
    }

    System.out.println(l);
    System.out.println(d);
    
  }
}
