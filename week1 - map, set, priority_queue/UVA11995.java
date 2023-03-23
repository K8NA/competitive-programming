
// https://www.programiz.com/java-programming/stack
// https://www.programiz.com/java-programming/queue
// https://www.geeksforgeeks.org/queue-remove-method-in-java/


/*
complexity - O(nlogn), logn is because of priorityQueue
idea: add elements to all data structures
then remove an element and see if it matches the value of x
*/

import java.util.*;
import java.io.*;

public class UVA11995 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n, op, x;
    boolean s, q, pq;

    Stack<Integer> stack;
    Queue<Integer> queue;
    PriorityQueue<Integer> priQueue;

    while (in.hasNextInt()) {
      stack = new Stack<Integer>();
      queue = new ArrayDeque<Integer>();
      priQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

      s=true; q=true; pq=true;

      n = in.nextInt();       // # of operations for this DS
      for (int i=0; i<n; i++) {
        op = in.nextInt();    // type of operation
        x = in.nextInt();     // element we put in / get back
        if (op == 1) {
          stack.push(x);
          queue.offer(x);
          priQueue.offer(x);
        } else {
          if (stack.isEmpty() || x != stack.pop())
            s = false;
          if (queue.isEmpty() || x != queue.poll())
            q = false;
          if (priQueue.isEmpty() || x != priQueue.poll())
            pq = false;
        }
      }

      if (!s && !q && !pq)
        System.out.println("impossible");
      else if (s && q || s && pq || q && pq)
        System.out.println("not sure");
      else if (s)
        System.out.println("stack");
      else if (pq)
        System.out.println("priority queue");
      else if (q)
        System.out.println("queue");
    }
    System.out.println();
  }

}
