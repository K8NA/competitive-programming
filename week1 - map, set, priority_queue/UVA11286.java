/*
idea: add to map of sets and increment, see if freq is higher
sort and get the max
linearythmic complexity - O(nlogn)
https://www.programiz.com/java-programming/treemap
*/

import java.util.*;
import java.io.*;

public class UVA11286 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int num = 5; //number of courses always selected
    int n = in.nextInt(); // number of frosh
    while (n != 0) {
      TreeMap<String, Integer> courses = new TreeMap<>();
      for (int i=0; i<n; i++) {
        int dis[] = new int[num];
        for (int j=0; j<num; j++) {
          dis[j] = in.nextInt();
        }
        Arrays.sort(dis);
        String s = Arrays.toString(dis);
        if (courses.get(s) == null)
          courses.put(s, 1); // course number, frequency of occurence
        else
          courses.put(s, courses.get(s) + 1);
      }
      int count=0;

      Integer[] popular = courses.values().toArray(new Integer[0]);
      Arrays.sort(popular);
      int max = popular[popular.length-1];

      for (String t : courses.keySet()) {
        if (courses.get(t) == max)
          count += max; // finding most people with similar courses
      }

      System.out.println(count);
      n = in.nextInt();
    }
  }
}
