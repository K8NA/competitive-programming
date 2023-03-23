
 // pie volume formula: pi*r*r*h, h = 1

 import java.util.*;
 import java.io.*;
 import static java.lang.Math.*;

 public class PIE {

   public static void main(String args[]) {
     Scanner in = new Scanner(System.in);

     int t = in.nextInt();

     for (int i=0; i<t; i++) {
       int n = in.nextInt(); // num of pies
       int f = in.nextInt(); // num of friends
       int people = f + 1; // total people, f+1 for the author
       double volumes[] = new double[n];
       for (int j=0; j<n; j++) {
         int r = in.nextInt();
         volumes[j] = PI*r*r;
       }
       double low = 0;
       double high = 1e20;

       for (int k=0; k<150; k++) {
         double mid = low + (high - low) / 2;
         int aux = 0;
         for (int l=0; l<n; l++) {
           aux += (int)(floor(volumes[l]/mid));
         }
         //System.out.println(aux + " " + mid);
         if (aux >= people)
          low = mid;
         else
          high = mid;
       }

       System.out.println(low);
     }
   }
 }
