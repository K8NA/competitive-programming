// https://www.spoj.com/problems/RKS/
// https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
// https://javaconceptoftheday.com/sort-array-elements-by-frequency-in-java/

/* complexity - O(n)
custom sort main idea
idea: store the input in an array
create a HashMap with digit representations as keys and their frequencies as values
then go through each number in the array, and before adding to the HashMap,
see if it was encountered before, incrementing the frequency if so
sort the map by frequency, and save onto an ArrayList
*/


import java.util.*;
import java.io.*;

public class RKSORT {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int c = in.nextInt();
    int message[] = new int[n];                    // storing the input
    for (int i=0; i<n; i++)
      message[i] = in.nextInt();

    // elements = keys, frequencies = values
    // maintains inserted order
    Map<Integer, Integer> digitAndCount = new LinkedHashMap<>();

    for (int i=0; i<n; i++) {
      if (digitAndCount.containsKey(message[i])) {
        // increment frequency by one if the digit already exists
        digitAndCount.put(message[i], digitAndCount.get(message[i])+1);
      } else {
        // register a new digit with frequency of 1
        digitAndCount.put(message[i], 1);
      }
    }

    //---------------------------------------
    // for (int key : digitAndCount.keySet())
    //   System.out.println(key);


    // digitAndCount.entrySet().forEach((entry) -> {
    //   for (int i=1; i<=entry.getValue(); i++)
    //     output.add(entry.getKey());
    //   });
    //---------------------------------------


    ArrayList<Integer> output = new ArrayList<>(); // storing the sorted output

    // sorting the original map by descending frequency (values in reverse order)
    // adding sorted values to the output list
    digitAndCount.entrySet()
                 .stream()
                 .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                 .forEach((entry) -> {
                   for (int i=1; i<=entry.getValue(); i++)
                     output.add(entry.getKey());
                   });

    for (int i=0; i<output.size(); i++) {
      System.out.print(output.get(i) + " ");
    }

    System.out.println();

  }
}
