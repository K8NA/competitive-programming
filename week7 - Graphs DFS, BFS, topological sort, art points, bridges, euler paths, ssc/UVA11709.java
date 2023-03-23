
/*
Trust groups - Strongly Connected Components
tarjan and DFS
*/

import java.util.*;
import java.io.*;

public class UVA11709 {
  static ArrayList<Integer>[] adjList;
  static Stack<Integer> stack;
  static int[] dfs_num, dfs_low;
  static boolean[] isSCC;
  static int p, t, countSCC, auxCounter;

  static void tarjan() {
    for (int i=0; i<p; i++)
      if (dfs_num[i] == 0)
        tarjanSCC(i);
  }

  static void tarjanSCC(int u) {
    dfs_num[u] = dfs_low[u] = ++auxCounter;
    stack.push(u);

    for (int v : adjList[u]) {
      if (dfs_num[v] == 0)
        tarjanSCC(v);
      if (!isSCC[v])
        dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
    }

    if (dfs_num[u] == dfs_low[u]) {
      while (true) {
        int v = stack.pop();
        isSCC[v] = true;
        if (v == u)
          break;
      }
      countSCC++;
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String s = bf.readLine();
    while (!s.equals("0 0")) {
      StringTokenizer st = new StringTokenizer(s);
      p = Integer.parseInt(st.nextToken());     // names of people
      int t = Integer.parseInt(st.nextToken()); // trust relations
      TreeMap<String, Integer> map = new TreeMap<>();
      stack   = new Stack<>();
      adjList = new ArrayList[p];
      dfs_num = new int[p];
      dfs_low = new int[p];
      isSCC   = new boolean[p];
      auxCounter = 0;
      countSCC   = 0;
      int k = 0;
      for (int i=0; i<p; i++)
        map.put(bf.readLine(), k++);
      for (int i=0; i<p; i++)
        adjList[i] = new ArrayList<>();
      for (int i=0; i<t; i++) {
        int n1 = map.get(bf.readLine());
        int n2 = map.get(bf.readLine());
        adjList[n1].add(n2);
      }
      tarjan();
      sb.append(countSCC + "\n");

    	s = bf.readLine();
    }
    System.out.print(sb);
  }
}
