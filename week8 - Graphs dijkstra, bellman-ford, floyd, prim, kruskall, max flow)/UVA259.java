/*
Max Flow - Maximum Bipartite Matching
*/

import java.io.*;
import java.util.*;

public class UVA259 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (br.ready()) {
      char result[] = new char[10];
      Arrays.fill(result, '_');
      int[][] res = new int[38][38];
      for (int i=27; i<=36; i++)
        res[i][37] = 1;
      int target = 0;
      int maxflow = 0;
      String input;
      while (br.ready() && !(input = br.readLine()).equals("")) {
        res[0][input.charAt(0)-'A'+1] += input.charAt(1)-'0';
        target += input.charAt(1)-'0';
        for (int i=3; input.charAt(i) != ';'; i++)
          res[input.charAt(0)-'A'+1][input.charAt(i)-'0'+27] = 1;
      }
      boolean done = false;
      while (!done) {
        done = true;
        long vis = 1L;
        Queue<Integer> q = new LinkedList<>();
        int parent[] = new int[38];
        parent[0] = 0;
        q.add(0);
        while (!q.isEmpty()) {
          int n = q.poll();
          if (n == 37) {
            done = false;
            break;
          } else
            for (int i=0; i<res[n].length; i++)
              if (res[n][i] > 0 && (vis & (1L << i)) == 0) {
                parent[i] = n;
                vis = vis | (1L << i);
                q.add(i);
              }
        }
        if (!done) {
          maxflow++;
          int node = 37;
          while (parent[node] != node) {
            res[parent[node]][node]--;
            res[node][parent[node]]++;
            node = parent[node];
          }
        }
      }
      for (int i=27; i<37; i++)
        for (int j=1; j<27; j++)
          if (res[i][j] == 1) {
            result[i-27] = (char)(j+'A'-1);
            break;
          }
      if (maxflow == target)
        System.out.println(new String(result));
      else
        System.out.println("!");
    }
  }
}
