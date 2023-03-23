import java.io.*;
import java.util.*;

public class A {

  public static void solve(Scanner in) {
    int n = in.nextInt();
    char s[] = in.next().toCharArray();
    int aux = 0;
    for (int i : s)
      if (i == 'R') aux++;

    if (aux == 0 || aux == n) {
      System.out.println("-1");
      return;
    }

    for (int i=0; i<n-1; i++) {
      if (s[i] == 'L' && s[i+1] == 'R') {
        System.out.println(i+1);
        return;
      }
      if (s[i] == 'R' && s[i+1] == 'L') {
        System.out.println("0");
        return;
      }
    }
    System.out.println("-1");
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      solve(in);
    }
  }
}
