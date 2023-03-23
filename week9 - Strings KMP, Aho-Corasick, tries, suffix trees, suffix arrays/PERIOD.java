/*
KMP pre processing
failure function
*/

import java.io.*;
import java.util.*;

public class PERIOD {

  static int[] KMP(char[] s) {
    int size = s.length;
    int v[] = new int[size];
    for (int i=1, j=0; i<size; i++) {
      while (j>0 && s[i]!=s[j])
        j = v[j-1];
      if (s[i] == s[j])
        j++;
      v[i] = j;
    }
    return v;
  }

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int t = Integer.parseInt(br.readLine());

    for (int k=1; k<=t; k++) {
      int n = Integer.parseInt(br.readLine());
      String s = br.readLine();
      int arr[] = KMP(s.toCharArray());
      pw.println("Test case #" + k);
      for (int i=1; i<n; i++) {
        int aux = i-arr[i]+1; // failure function applied to prefix i
        if (arr[i] > 0 && (i+1) % aux == 0)
          pw.println((i+1) + " " + (i+1)/aux);
      }
      pw.println();
    }
    pw.flush();
  }

}
