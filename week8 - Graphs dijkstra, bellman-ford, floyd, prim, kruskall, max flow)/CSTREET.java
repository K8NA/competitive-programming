/*
Simple MST with Prim and PQ
*/

import java.io.*;
import java.util.*;

public class CSTREET {

  public static class Edge implements Comparable<Edge> {
		int edge;
		int cost;
		public Edge(int edge, int cost) {
			//super();
			this.edge = edge;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}

  public static class Vertex {
    ArrayList<Edge> neighbours;
    public Vertex() {
      neighbours = new ArrayList<Edge>();
    }
  }

  private static int Prim(Vertex[] graph, int source) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[graph.length];
		int cost = 0;
		visited[source] = true;

		for (Edge e : graph[source].neighbours)
			pq.add(e);
    // System.out.println("graph.length"+visited.length);

		while (!pq.isEmpty()) {
			Edge cur = pq.remove();
			if (visited[cur.edge])
				continue;
			visited[cur.edge] = true;
			cost += cur.cost;
			// System.out.println(cost);

			for (Edge e : graph[cur.edge].neighbours) {
				if (visited[e.edge])
					continue;
				pq.add(e);
			}
		}

		for (int i=1; i<visited.length; i++)
			if (!visited[i])
				return -1;

		return cost;
	}

  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i=0; i<t; i++) {
			int p = in.nextInt();
			int vertices = in.nextInt();
			int edges = in.nextInt();

			Vertex[] graph = new Vertex[vertices+1];

			for (int j=0; j<=vertices; j++)
				graph[j] = new Vertex();

			for (int k=0; k<edges; k++) {
				int start = in.nextInt();
				int finish = in.nextInt();
				int cost = in.nextInt();
				graph[start].neighbours.add(new Edge(finish, cost));
				graph[finish].neighbours.add(new Edge(start, cost));
			}

		 System.out.println(Prim(graph, 1)*p);
		}
	}
}
