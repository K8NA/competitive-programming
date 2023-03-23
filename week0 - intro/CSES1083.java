

import java.util.*;
import java.io.*;

public class CSES1083 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

		int n = in.nextInt();
    int num[] = new int[n-1];

    for (int i=0; i<n-1; i++)
      num[i] = in.nextInt();

    int total = 1;
    for (int i=2; i<=n; i++)
      total += i - num[i-2];

    System.out.println(total);

  }
}
