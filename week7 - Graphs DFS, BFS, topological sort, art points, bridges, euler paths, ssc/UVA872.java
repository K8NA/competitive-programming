
/*
Topological Sorting with Kahn
*/

import java.util.*;
import java.io.*;

public class UVA872 {
  static int[] adj;
  static int[] indeg;
  static int[][] adjMat;
  static char[] reverse = new char[21];
  static ArrayList<Integer> ts;

  static boolean Kahn(int V, ArrayList<Integer> answer) {
      if (answer.size() == V) {
          boolean first = true;
          for (int i=0; i<V; ++i) {
              if (i!=0) System.out.print(" ");
              System.out.print(reverse[answer.get(i)]);
          }
          System.out.println();
          return true;
      }
      // will either sort all or fail to sort any
      boolean hasAns = false;
      for (int i=0; i<V; ++i) {
          if (indeg[i] == 0) {
              answer.add(i);
              indeg[i]--;
              for (int j=0; j<adj[i]; ++j)
                  indeg[adjMat[i][j]]--;
              boolean result = Kahn(V, answer);
              hasAns = hasAns || result;
              answer.remove(answer.size()-1);
              ++indeg[i];
              for(int j=0; j<adj[i]; ++j)
                  indeg[adjMat[i][j]]++;
          }
      }
      return hasAns;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
    adj    = new int[21];
    adjMat = new int[21][21];
    indeg  = new int[21];

    int c = in.nextInt();
    in.nextLine();

    for (int i=0; i<c; ++c) {
      if (!in.hasNext()) break;
      in.nextLine();

      Arrays.fill(adj, 0);
      for(int j=0; j<21; ++j)
          Arrays.fill(adjMat[j], 0);
      Arrays.fill(indeg, 0);

      ts = new ArrayList<Integer>();
      int count = 0;
      String nodes = in.nextLine();
      StringTokenizer st = new StringTokenizer(nodes);
      while (st.hasMoreTokens()) {
          String t = st.nextToken();
          map.put(t.charAt(0), count);
          reverse[count] = t.charAt(0);
          count++;
      }

      String order = in.nextLine();
      st = new StringTokenizer(order);
      while (st.hasMoreTokens()) {
          String o = st.nextToken();
          char cs = o.charAt(0);
          char ct = o.charAt(2);
          int s = map.get(cs);
          int t = map.get(ct);
          adjMat[s][adj[s]++] = t;
          indeg[t]++;
      }

      ts.clear();
      if (!Kahn(count, new ArrayList<Integer>()))
          System.out.println("NO");
      if (i!=c-1) System.out.println();
    }
  }
}
