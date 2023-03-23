/*
LIS in O (nlogn)
*/

import java.util.*;
import java.io.*;

public class UVA10534 {

  static int n;
  static int inc[];
  static int dec[];

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      n = in.nextInt();
      int arr[] = new int[n];
      int rev[] = new int[n];
      for (int i=0; i<n; i++) {
        int elem   = in.nextInt();
        arr[i]     = elem;
        rev[n-1-i] = elem;
      }

      inc = new int[n];
      dec = new int[n];

      LIS(arr, true);
      LIS(rev, false);

      int max = -1;
      int min = Integer.MAX_VALUE;

      for (int i=0; i<n; i++) {
        min = Math.min(inc[i], dec[i]);
        max = Math.max(max, min+min-1);
      }
      System.out.println(max);
    }
  }


  public static int LIS(int[] v, boolean reversed) {
    int index[] = new int[10001];
    int size = 0;

    for (int i=0; i<v.length; i++) {

      // binary search
      int low  = 0;
      int high = size-1;
      int ans  = size;
      while (low <= high) {
        int mid = low+(high-low) / 2;
        if (v[i] <= v[index[mid]]) {
          high = mid - 1;
          ans  = mid;
        } else
          low = mid + 1;
      }

      index[ans] = i; // allows smaller wavios

      if (!reversed)
        inc[i]     = ans+1;
      else
        dec[n-1-i] = ans+1;

      if (ans == size)
        size++;
    }

    return size;
  }
}
