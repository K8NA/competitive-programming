/*
BIT with range update + range sum query
*/

import java.util.*;
import java.io.*;

public class HORRIBLE {

  public static class BITree {
    long[] tree;

    public BITree(int n) {
      tree = new long[n+1];
    }

    public BITree(long[] zeroBasedArr) {
      tree = new long[zeroBasedArr.length+1];
      for (int i=0; i<zeroBasedArr.length; i++)
        increment(i+1, zeroBasedArr[i]);
    }

    public void increment(int i, long val) {
      while (i<tree.length) {
        tree[i] += val;
        i += i & (-i);
      }
    }

    public long getSum(int i) {
      long sum = 0;
      while (i>0) {
        sum += tree[i];
        i -= i & (-i);
      }
      return sum;
    }
  }

  static class FenwickPoint {
    public BITree tree;

    public FenwickPoint(int n) {
      tree = new BITree(n);
    }

    public void update(int i, int j, long v) {
      tree.increment(i, v);
      tree.increment(j+1, -v);
    }

    public long query(int i) {
      return tree.getSum(i);
    }
  }

  static class FenwickRange {
    FenwickPoint mul;
    FenwickPoint add;
    int n;

    public FenwickRange(int n) {
      this.n = n;
      mul = new FenwickPoint(n);
      add = new FenwickPoint(n);
    }

    public void update(int i, int j, long v) {
      mul.update(i, j, v);
      add.update(i, j, (1-i)*v);
      add.update(j+1, n, (j-i+1)*v);
    }

    public long query(int i, int j) {
      return query(j) - query(i-1);
    }

    public long query(int i) {
      return mul.query(i)*i + add.query(i);
    }
  }

  public static void main(String args[]) {
    FastInput in = new FastInput();
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    int t = in.nextInt(); // n of test cases

    for (int test=0; test<t; test++) {
      int n = in.nextInt(); // n of elements in array
      FenwickRange tree = new FenwickRange(n);
      int c = in.nextInt(); // n of commands
      for (int i=0; i<c; i++) {
        int num = in.nextInt();
        if (num == 0) {
          int p = in.nextInt();
          int q = in.nextInt();
          int v = in.nextInt();
          tree.update(p, q, v);
        } else {
          int p = in.nextInt();
          int q = in.nextInt();
          out.println(tree.query(p, q));
        }
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
