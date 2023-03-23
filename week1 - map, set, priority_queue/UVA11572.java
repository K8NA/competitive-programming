/*
complexity - O(n^2)
idea: process each snowflake by adding it to the map, and beforehand
checking if it already exists; if so, set the max number of unique snowflakes
to be the number before the repeating snowflake, and reset the start point
to be the next snowflake.
*/

import java.util.*;
import java.io.*;

public class UVA11572 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int cases = in.nextInt();      // # of test cases

    for (int i=0; i<cases; i++) {
      HashMap<Integer, Integer> snowflakes = new HashMap<>();
      int n = in.nextInt();        // # of snowflakes
      int start = 0, max = 0;
      for (int j=0; j<n; j++) {
        int flake = in.nextInt();
        if (snowflakes.containsKey(flake)) {
          max = Math.max(max, j-start);
          start = Math.max(start, snowflakes.get(flake)+1);
        }
        snowflakes.put(flake, j);  // snowflake id, snowflake number
      }
      max = Math.max(max, n-start);
      System.out.println(max);
    }

  }
}
