
/*
Rank the languages - DFS, Flood Fill
*/

import java.util.*;
import java.io.*;

public class UVA10336 {
  static int h, w;
  static char world[][];
  static boolean visited[][];

  static boolean valid(int r, int c, char ch) {
    return (r >= 0 && c >= 0 && r < h && c < w
            && world[r][c] == ch && !visited[r][c]);
  }

  static void dfs(int r, int c, char ch) {
    if (!valid (r, c, ch)) return;
    visited[r][c] = true;
    dfs(r-1, c, ch);
    dfs(r+1, c, ch);
		dfs(r, c-1, ch);
		dfs(r, c+1, ch);
  }

  static class State implements Comparable<State> {
    char state;
    int rank;

    public State(char s, int r) {
      this.state = s;
      this.rank = r;
    }

    public int compareTo(State s) {
      if (this.rank != s.rank)
        return s.rank - this.rank;
      return this.state - s.state;
    }

    public String toString() {
      return this.state + ": " + this.rank;
    }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    for (int n=1; n<=t; n++) {
      h = in.nextInt();
      w = in.nextInt();

      world = new char[h][w];
      visited = new boolean[h][w];
      int count[] = new int[30];

      for (int i=0; i<h; i++)
        world[i] = in.next().toCharArray();

      // for (int i=0; i<h; i++) {
      //   for (int j=0; j<w; j++)
      //     System.out.print(world[i][j]);
      //   System.out.println();
      // }

      for (int i=0; i<h; ++i)
        for (int j=0; j<w; ++j)
          if (!visited[i][j]) {
            char ch = world[i][j];
            ++count[ch-'a'];
            dfs(i, j, ch);
          }

      List<State> countries = new ArrayList<>();

      for (char ch='a'; ch<='z'; ++ch)
        if (count[ch-'a'] > 0)
          countries.add(new State(ch, count[ch-'a']));

      Collections.sort(countries);

      System.out.println("World #" + n);

      for (State s : countries)
        System.out.println(s);

    }
  }
}
