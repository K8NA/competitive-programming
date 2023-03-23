
import java.io.*;
import java.util.*;

public class KNAPSACK {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int cap = in.nextInt();
		int amt = in.nextInt();
		int[] s = new int[cap+1];
		int[] v = new int[amt+1];

		for (int i=1; i<=amt; i++) {
			s[i] = in.nextInt();
			v[i] = in.nextInt();
		}

		int[][] dp = new int[cap+1][amt+1];
		for (int i=0; i<=cap; i++)
			for (int j=1; j<=amt; j++) {
				dp[i][j] = dp[i][j-1];
				if (i-s[j] >= 0)
					dp[i][j] = Math.max(dp[i][j], v[j] + dp[i-s[j]][j-1]);
			}
		System.out.println(dp[cap][amt]);
	}
}
