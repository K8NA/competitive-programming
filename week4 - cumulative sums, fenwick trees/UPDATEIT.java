/*
no need for BIT
*/

import java.util.*;
import java.io.*;

public class UPDATEIT {

  public static void main(String args[]) {
    FastInput in = new FastInput();
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    int t = in.nextInt(); // n of test cases

    for (int j=0; j<t; j++) {
      int n = in.nextInt(); // n of elements
      int u = in.nextInt(); // n of updates
      int arr[] = new int[n+1];

      for (int i=0; i<u; i++) {
        int l   = in.nextInt(); // starting index
        int r   = in.nextInt(); // ending index
        int val = in.nextInt(); // value to be added to elements
        arr[l] += val;
        arr[r+1] -= val;
      }
      for (int k=1; k<=n; k++)
        arr[k] += arr[k-1];

      int q = in.nextInt(); // n of queries
      for (int i=0; i<q; i++) {
        int index = in.nextInt();
        out.println(arr[index]);
      }
    }
    out.close();
  }

//------------------------------------

  static class FastInput {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    public String next() {
      while (!st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }

}
