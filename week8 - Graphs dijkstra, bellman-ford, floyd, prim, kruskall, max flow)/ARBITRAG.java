
/*
Floyd-Warshall algorithm
complexity per case = O(n³), where n = number of currencies
*/

import java.io.*;
import java.lang.*;
import java.util.*;

public class ARBITRAG {

  private static boolean isPossible(double[][] edges, int vertices) {
    floydWarshall(edges, vertices);
    for (int u=0; u<vertices; u++)
      if (edges[u][u] > 1.0)
          return true;
    return false;
  }

  private static void floydWarshall(double[][] edges, int vertices) {
    for (int p=0; p<vertices; p++)
      for (int u=0; u<vertices; u++)
        for (int v=0; v<vertices; v++)
          edges[u][v] = Math.max(edges[u][v], edges[u][p] * edges[p][v]);
  }

  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int idx = 1;
      while (true) {
        int n = in.nextInt();
        if (n == 0) break;
        double[][] edges = new double[n][n];

        Map<String, Integer> vertexMap = new HashMap<>();
        for (int i=0; i<n; i++)
          vertexMap.put(in.next(), i);

        int e = in.nextInt();
        for (int i=0; i<e; i++) {
          int u = vertexMap.get(in.next());
          double w = in.nextDouble();
          int v = vertexMap.get(in.next());
          edges[u][v] = w;
        }

        if (!isPossible(edges, n))
          System.out.println("Case " + idx + ": No");
        else
          System.out.println("Case " + idx + ": Yes");

        idx++;
      }
   }
}
