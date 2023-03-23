
/*
https://vjudge.net/problem/UVA-12532 Interval Product
complexity - O(nlogn)
*/

import java.util.*;
import java.io.*;

class SegTree {
	int n;
  int t[];

	SegTree(int n) {
		this.n = n;
		t = new int[4*n];
    Arrays.fill(t, 1); // necessary to perform the product operation
	}

	void build(int v[], int i, int tl, int tr) {
	    if (tl == tr)
	     t[i] = v[tl];
	    else {
        int tmid = (tl + tr) / 2;
        build(v, i*2, tl, tmid);
        build(v, i*2+1, tmid+1, tr);
        t[i] = t[i*2] * t[i*2+1];
	    }
	}

  int mult(int i, int tl, int tr, int l, int r) {
    if (l > r)
      return 1;
    if (l == tl && r == tr)
      return t[i];
    int tmid = (tl + tr) / 2;
    return mult(i*2, tl, tmid, l, Math.min(r, tmid)) *
           mult(i*2+1, tmid+1, tr, Math.max(l, tmid+1), r);
}

	void update(int i, int tl, int tr, int pos, int newVal) {
	    if (tl == tr)
	     t[i] = newVal;
	    else {
        int tmid = (tl + tr) / 2;
        if (pos <= tmid)
          update(i*2, tl, tmid, pos, newVal);
        else
          update(i*2+1, tmid+1, tr, pos, newVal);
        t[i] = t[i*2] * t[i*2+1];
	    }
	}
}

public class UVA12532 {

	static int polarity(int v) {
		if (v > 0) return 1;
		if (v < 0) return -1;
		return 0;
	}

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    while (in.hasNextInt()) {

      int n = in.nextInt();
      int v[] = new int[n];
      SegTree tree = new SegTree(n);
      int k = in.nextInt();

      for (int i=0; i<n; i++)
        v[i] = polarity(in.nextInt());

      tree.build(v, 1, 0, n-1);
      // tree.printArray();

      for (int i=0; i<k; i++) {
        String str = in.next();
        int val1   = in.nextInt();
        int val2   = in.nextInt();

        if (str.equals("C")) {
          val2 = polarity(val2);
          tree.update(1, 0, n-1, val1-1, val2);
        } else { // regular query
          int result = tree.mult(1, 0, n-1, val1-1, val2-1);
					//System.out.println(result);
					if (result == 0)
            System.out.print("0");
					if (result > 0)
            System.out.print("+");
					if (result < 0)
            System.out.print("-");
        }
      }
      System.out.println();
    }
  }
}
