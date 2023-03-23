/*
checking if polygon is convex
*/

import java.lang.*;
import java.awt.Polygon;
import java.util.*;
import java.io.*;

public class UVA10078 {

  public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int n; (n = Integer.parseInt(br.readLine().trim())) != 0; ) {
			int[][] points = new int[n][2];
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			boolean convex = true;
			for (int i=0; i<n && convex; i++) {
				Polygon p = new Polygon();
				for (int j=0; j<n && convex; j++)
          if (i!=j)
            p.addPoint(points[j][0], points[j][1]);
				convex = !p.contains(points[i][0], points[i][1]);
			}
			System.out.println(convex ? "No" : "Yes");
		}

  }
}
