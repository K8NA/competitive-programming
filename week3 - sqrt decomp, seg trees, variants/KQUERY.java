
/*
segment tree + offline queries
*/

 import java.util.*;
 import java.io.*;

 public class KQUERY {

   public static void main(String args[]) throws NumberFormatException, IOException {
     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     PrintWriter out = new PrintWriter(System.out);

     int n = Integer.parseInt(in.readLine());
     int v[] = new int[n];
     SegTree tree = new SegTree(n);

     StringTokenizer str = new StringTokenizer(in.readLine());

     for (int a=0; a<n; a++)
       v[a] = Integer.parseInt(str.nextToken());

     int q = Integer.parseInt(in.readLine());
     int result[] = new int[q];
     Element arr[] = new Element[n+q];

     for (int a=0; a<n; a++)
       arr[a] = new Element(v[a], a+1);

     for (int a=n; a<n+q; a++) {
       str = new StringTokenizer(in.readLine());
       int l = Integer.parseInt(str.nextToken());
       int r = Integer.parseInt(str.nextToken());
       int k = Integer.parseInt(str.nextToken());
       arr[a] = new Element(k, l, r, a-n);
     }

     sort(arr);

     for (int i=arr.length-1; i>-1; i--) {
       Element e = arr[i];
       if (e.isQuery)
        result[e.i] = tree.query(e.l, e.r);
       else
        tree.update(e.i, 1);
     }

     for (int b : result)
      out.println(b);
      
     out.close();
   }

   static class SegTree {
    int N;
    int tree[];

    public SegTree(int n) {
    	N = 1;
      while (N < n)
        N <<= 1;
    	tree = new int[2*N];
    }

    public void update(int i, int value) {
      i += N-1;
      tree[i] += value;
      while (i > 1) {
        i >>= 1;
        tree[i] = tree[i << 1] + tree[(i << 1) | 1];
      }
    }

    public int query(int l, int r) {
      return query(1, 1, N, l, r);
    }

    public int query(int node, int s, int e, int l, int r) {
      if (e < l || s > r)
        return 0;
      if (s >= l && e <= r)
        return tree[node];

      int leftChild = node << 1;
      int rightChild = leftChild | 1;
      int mid = s + e >> 1;

      return query(leftChild, s, mid, l, r) +
             query(rightChild, mid + 1, e, l, r);
    }
  }

  static class Element implements Comparable {
    int val;
    int l, r;
    int i;
    boolean isQuery;

    public Element(int val, int i) {
      this.val     = val;
      this.i       = i;
      this.isQuery = false;
    }

    public Element(int val, int l, int r, int i) {
      this.val     = val;
      this.i       = i;
      this.l       = l;
      this.r       = r;
      this.isQuery = true;
    }

    @Override
    public int compareTo(Object e) {
      Element o = (Element) e;
      return this.val - o.val;
    }

    @Override
    public String toString() {
      return val + "";
    }
  }

  static void merge(Element[] v, int b, int m, int e) {
    int len1 = m-b+1;
    int len2 = e-m;
    Element l[] = new Element[len1];
    Element r[] = new Element[len2];

    for (int i=0; i<len1; i++)
      l[i] = v[b+i];
    for (int i=0; i<len2; i++)
      r[i] = v[m+1+i];

    int i=0, j=0, k=b;
    while (i<len1 && j<len2) {
      if (l[i].compareTo(r[j]) < 0)
        v[k++] = l[i++];
      else if (l[i].compareTo(r[j]) == 0) {
        if (l[i].isQuery)
          v[k++] = r[j++];
        else
          v[k++] = l[i++];
      } else
        v[k++] = r[j++];
    }

    while (i<len1)
      v[k++] = l[i++];
    while (j<len2)
      v[k++] = r[j++];
    return;
  }

  static void mergeSort(Element v[], int b, int e) {
    if (b < e) {
      int mid = b + (e - b) / 2;
      mergeSort(v, b, mid);
      mergeSort(v, mid + 1, e);
      merge(v, b, mid, e);
    }
    return;
  }

  public static void sort(Element v[]) {
    mergeSort(v, 0, v.length-1);
  }

 }
