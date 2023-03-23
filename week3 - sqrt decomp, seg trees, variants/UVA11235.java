/*
https://vjudge.net/problem/UVA-11235 Frequent Values
complexity - O(nlogn)
*/

import java.util.*;
import java.io.*;


class Node {
	int rvalue;  // mostright value
	int lvalue;  // mostleft value
	int rqvalue; // quantity right
	int lqvalue; // quantity left
	int max;     // max until

	Node(int value) {
		rvalue  = value;
		lvalue  = value;
		rqvalue = 1;
		lqvalue = 1;
		max     = 1;
	}

	Node(int lvalue, int rvalue, int lqvalue, int rqvalue, int max) {
		this.rvalue  = rvalue;
		this.lvalue  = lvalue;
		this.rqvalue = rqvalue;
		this.lqvalue = lqvalue;
		this.max     = max;
	}

	int getRValue() {
    return rvalue; }

	int getLValue() {
    return lvalue; }

	int getRQValue() {
    return rqvalue; }

	int getLQValue() {
    return lqvalue; }

	int getMax() {
    return max; }
}

class SegTree {

	int n;
	Node t[];

	SegTree(int n) {
		this.n = n;
		t = new Node[4*n];
	}

	void build(int v[], int i, int tl, int tr) {
	    if (tl == tr)
	     t[i] = new Node(v[tl]);
	    else {
        int tmid = (tl + tr) / 2;
        build(v, i*2, tl, tmid);
        build(v, i*2+1, tmid+1, tr);
        t[i] = merge(t[i*2], t[i*2+1]);
	    }
	}

  Node merge(Node l, Node r) {
    int a, b;
    int left  = l.getRValue(); // rightmost value of the left node
    int right = r.getLValue(); // leftmost value of the right node
    if (left == -1000000)
      return r;
    if (right == -1000000)
      return l;
    int leftQ  = l.getRQValue();
    int rightQ = r.getLQValue();
    int max    = Math.max(l.getMax(), r.getMax());
    if (left == right)
      if (leftQ + rightQ > max)
        max = leftQ + rightQ;
    if (l.getLValue() == right)
      a = l.getLQValue() + rightQ;
    else
      a = l.getLQValue();
    if (r.getRValue() == left)
      b = r.getRQValue() + leftQ;
    else
      b = r.getRQValue();
    return new Node(l.getLValue(), r.getRValue(), a, b, max);
  }

  Node search(int i, int tl, int tr, int l, int r) {
    if (l > r)
      return new Node(-1000000);  // check
    if (l == tl && r == tr)
      return t[i];
    int tmid = (tl + tr) / 2;
    return merge(search(i*2, tl, tmid, l, Math.min(r, tmid)),
                 search(i*2+1, tmid+1, tr, Math.max(l, tmid+1), r));
  }

  void printArray() {
    for (int i=0; i<4*n; i++)
      if (t[i] != null)
        System.out.println("t[" + i + "]= " + t[i].getMax());
  }
}

public class UVA11235 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n, q, start, end;

    while ((n = in.nextInt()) != 0) {
      int[] v = new int[n];
      SegTree tree = new SegTree(n);
      q = in.nextInt();
      for (int i=0; i<n; i++)
        v[i] = in.nextInt();
      tree.build(v, 1, 0, n-1);
      // tree.printArray();
      for (int j=0; j<q; j++) { // queries
        start = in.nextInt();   // i
        end = in.nextInt();     // j
        System.out.println((tree.search(1, 0, n-1, start-1, end-1)).getMax());
      }
    }
  }
}
