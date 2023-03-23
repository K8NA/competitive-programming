
/*
Given a string, calculate the number of different strings
that can be created using its characters
permutations
*/

import java.util.*;
import java.io.*;

public class CSES1715 {

  static final int a = 26;
  static final int md = 1000000007;

  public static long power(int a, int k) {
    if (k == 0)
      return 1;
    long p = power(a, k/2);
    p = p * p % md;
    if (k%2 == 1)
      p = p * a % md;
    return p;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] str = br.readLine().toCharArray();
    int n = str.length;
    int[] v = new int[n+1];
    int[] arr = new int[a];
    for (int i=0; i<n; i++)
      arr[str[i]-'a']++;
    int f = 1;
    for (int i=0; i<=n; i++) {
      v[i] = f;
      f = (int)((long) f * (i+1) % md);
    }
    long ans = v[n];
    for (int i=0; i<a; i++)
      ans = ans * power(v[arr[i]], md-2) % md;
    System.out.println(ans);
  }
}
