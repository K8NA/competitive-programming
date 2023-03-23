/*
https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
*/

import java.io.*;
import java.util.*;

public class MSE06H {

  static class BITree {
    int n;
    int[] BITree;

    public BITree(int n) {
      this.n = n;
      BITree = new int[n+1];
    }

    public int getSum(int i) {
      int sum = 0;
      while (i>0) {
        sum += BITree[i];
        i -= i & (-i);
      }
      return sum;
    }

    public void update(int i, int val) {
      while (i<=n) {
        BITree[i] += val;
        i += i & (-i);
      }
    }
  }

  static class Highway {
    int x; // source
    int y; // destination

    public Highway(int a, int b) {
      x = a;
      y = b;
    }

    public Highway(Highway h) {
      this.x = h.x;
      this.y = h.y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }

  static class CompareHighways implements Comparator<Highway> {
    public int compare(Highway p, Highway q) {
      if (p.getX() < q.getX())
        return -1;
      else if ((p.getX() == q.getX()) && (p.getY() < q.getY()))
        return -1;
      return 1;
    }
  }

  public static void main(String args[]) throws IOException {
    Reader in = new Reader();
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    int t = in.nextInt();

    for (int i=0; i<t; i++) {
      int n = in.nextInt(); // n of EC cities
      int m = in.nextInt(); // n of WC cities
      int k = in.nextInt(); // n of highways
      BITree tree = new BITree(n);
      Highway[] h = new Highway[k];

      for (int j=0; j<k; j++) {
        int x = in.nextInt();
        int y = in.nextInt();
        h[j] = new Highway(x, y);
      }

      Arrays.sort(h, new CompareHighways());
      long count = 0L;

      for (int c=k-1; c>=0; c--) {
        tree.update(h[c].getY(), 1);
        count += tree.getSum(h[c].getY()-1);
      }

      out.println("Test case " + (i+1) + ": " + count);
    }

    out.close();
  }

//----------------------------------------------------------------------
  static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
      byte[] buf = new byte[64];
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == '\n')
            break;
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg)
          return -ret;
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      }
      while ((c = read()) >= '0' && c <= '9');
      if (neg)
        return -ret;
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (c == '.')
        while ((c = read()) >= '0' && c <= '9')
          ret += (c - '0') / (div *= 10);
      if (neg)
        return -ret;
      return ret;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1)
        buffer[0] = -1;
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead)
        fillBuffer();
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null)
        return;
      din.close();
    }
  }

 }
