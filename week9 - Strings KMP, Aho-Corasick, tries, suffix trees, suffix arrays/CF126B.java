
/*
KMP string matching

https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
*/

import java.util.*;
import java.io.*;

public class CF126B {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int size = s.length();
    int lps[] = new int[size+1];
    lps[0] = -1;

    for (int i=0; i<size; i++) {
      int j = lps[i];
      while (j!=-1 && s.charAt(i) != s.charAt(j))
        j = lps[j];
      lps[i+1] = ++j;
    }

    int ans = lps[size];
    while (ans != 0) {
      for (int i=0; i<size; i++)
        if (ans == lps[i]) {
          System.out.println(s.substring(0, ans));
          return;
        }
      ans = lps[ans];
    }
    System.out.println("Just a legend");

  }
}
