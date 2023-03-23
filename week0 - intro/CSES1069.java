

import java.util.*;
import java.io.*;

public class CSES1069 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String dna = in.next();
    char seq[] = new char[dna.length()];

    for (int i=0; i<dna.length(); i++)
      seq[i] = dna.charAt(i);

    int max = 1, count = 1;
    for (int i=1; i<seq.length; i++) {
      if (seq[i] == seq[i-1]) {
        count++;
        if (max <= count)
          max = count;
      } else
        count = 1;
    }

    System.out.println(max);

  }
}
