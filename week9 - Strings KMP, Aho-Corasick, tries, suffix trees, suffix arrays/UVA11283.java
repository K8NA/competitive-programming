
/*
Trie + DFS with backtracking
string matching
*/

import java.io.*;
import java.util.*;

public class UVA11283 {

	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static boolean[][] visited;
	static char[][] board;

	static boolean dfs (String word, int i, int r, int c) {
		if (word.charAt(i) != board[r][c]) return false;
		if (i == word.length()-1) return true;
		boolean res = false;
		for (int j=0; j<8; j++) {
			int rx = r + dx[j];
			int cy = c + dy[j];
			if (rx >= 0 && rx < 4 && cy >= 0 && cy < 4 && !visited[rx][cy]) {
				visited[rx][cy] = true;
				res = res | dfs(word, i + 1, rx, cy);
				visited[rx][cy] = false;
			}
		}
		return res;
	}

	static int total (String s) {
		int n = s.length();
		if (n == 3 || n == 4) return 1;
		if (n == 5) return 2;
		if (n == 6) return 3;
		if (n == 7) return 5;
		if (n >= 8) return 11;
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int k=1; k<=t; k++) {

			board = new char[4][4];
			for (int i = 0; i < 4; ++i)
				board[i] = in.next().toCharArray();

			int m = in.nextInt();
			int score = 0;
			for (int i=0; i<m; i++) {
				String word = in.next();
				boolean found = false;
				for (int r=0; r<4 && !found; r++)
					for (int c=0; c<4 && !found; c++) {
						visited = new boolean[4][4];
						visited[r][c] = true;
						if (dfs(word, 0, r, c)) {
							found = true;
							score += total(word);
						}
					}
			}
			System.out.println("Score for Boggle game #" + k + ": " + score);
		}

	}
}
