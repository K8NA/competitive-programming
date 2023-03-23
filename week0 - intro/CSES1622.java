
// public static boolean next_permutation(int[] p) {
//   for (int a=p.length-2; a>=0; --a)
//     if (p[a] < p[a + 1])
//       for (int b=p.length-1; ; --b)
//         if (p[b] > p[a]) {
//           char t = p[a];
//           p[a] = p[b];
//           p[b] = t;
//           for (++a, b=p.length-1; a<b; ++a, --b) {
//             t = p[a];
//             p[a] = p[b];
//             p[b] = t;
//           }
//           return true;
//         }
//   return false;
// }

import java.util.*;
import java.io.*;

public class CSES1622 {
  static TreeSet<String> set;

  static void perm (String left, String right) {
    if (right.length() == 0)
      set.add(left);
    for (int i=0; i<right.length(); i++) {
      String l = left + right.charAt(i);
      String r = right.substring(0, i) + right.substring(i+1);
      perm(l, r);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    set = new TreeSet<>();
    String str = in.next();
    perm("", str);

    StringBuilder sb = new StringBuilder();
    sb.append(set.size()).append("\n");
		for (String t: set)
			sb.append(t).append("\n");

		System.out.println(sb);
  }
}
