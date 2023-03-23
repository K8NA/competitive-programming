/*
BFS with prime numbers (generates the prime table)
*/

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class PPATH {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    boolean prime[] = new boolean[10000];
    for (int i=2; i<prime.length; i++)
      if (!prime[i])
        for (int j=i*2; j<prime.length; j+=i)
          prime[j] = true;

    int t = in.nextInt();
    for (int i=0; i<t; i++) {
      int st  = in.nextInt();
      int end = in.nextInt();
      Queue<Integer> q = new LinkedList<>();
      q.add(st);
      boolean visited[] = new boolean[10000];
      int ans = -1;

      while (q.size() > 0) {
        int n = q.poll();
        int cur = n & 0xFFFF;
        int cost = n >>> 16;
        visited[cur] = true;

        if (cur == end) {
          ans = cost;
          break;
        }

        for (int j=0; j<4; j++) {
          for (int k=0; k<10; k++) {
            int numAux = (int)(pow(10, j));
            int num = cur%numAux + k*numAux
                      + (cur/(numAux*10))*numAux*10;
            if (num < 1000)   continue;
            if (num >= 10000) continue;
            if (visited[num]) continue;
            if (prime[num])   continue;
            visited[num] = true;
            q.offer((cost+1) << 16 | (num));
          }
        }
      }
      if (ans == -1)
        System.out.println("Impossible");
      else
        System.out.println(ans);
    }
  }
}
