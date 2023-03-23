/*
idea: put every day's bills in a treeset that automatically
sorts them lowest to highest, then calculate the difference
and add it up for each day
compexity - O(n2^)

https://www.programiz.com/java-programming/treeset
*/

import java.util.*;
import java.io.*;

public class UVA11136 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    long daytotal = 0, total = 0;

    while (true) {
      int n = in.nextInt();        // # of promotion days
      if (n==0) break;
      int billArray[] = new int[1000001];
      TreeSet<Integer> bills = new TreeSet<>();
      for (int i=0; i<n; i++) {
        long k = in.nextInt();     // # of bills on i-th day
        for (int j=0; j<k; j++) {
          int bill = in.nextInt(); // bill amount
          if (billArray[bill] == 0)
            bills.add(bill);  //add every bill
          billArray[bill]++;
        }

        int last = bills.last();
        int first = bills.first();

        if (bills.size() == 1)
          daytotal = 0;
        else
          daytotal = (bills.last() - bills.first());
        //System.out.println("prize total today: " + daytotal);
        total += daytotal;
        billArray[last]--;
        billArray[first]--;

        if (billArray[last] == 0)
          bills.pollLast();
        if (billArray[first] == 0)
          bills.pollFirst();
      }

      System.out.println(total);
      total = 0;
    }
  }
}
