package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1861 {
	static int T, n, curR, curC, nexR, nexC, idx, result, answer, answerIdx;
	static int[] cur, resultSet;
	static int[][] grid;
	static boolean[][] visited;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim()); 
		for (int t = 1; t < T+1; t++) {
			n = Integer.parseInt(br.readLine().trim());
			grid = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			} // grid 반복문 끝
		
			answer = 0;
			answerIdx = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(i,j);
				}
			}
			System.out.println("#" + t + " " + answerIdx + " " + answer);
		}  // tc 반복문 끝	
	}  // main 함수 끝

	public static void bfs(int r, int c) {
		dq = new ArrayDeque<>();
		visited = new boolean[n][n];
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int[] s = {r,c};
		idx = grid[r][c];
		result = 1;
		dq.add(s);

		while (!dq.isEmpty()) {
			cur = dq.pollFirst();
			curR = cur[0];
			curC = cur[1];
			for (int i = 0; i < 4; i++) {
				nexR = curR + dr[i];
				nexC = curC + dc[i];
				if (0 <= nexR && nexR < n && 0 <= nexC && nexC < n && !visited[nexR][nexC]) {
					if (grid[nexR][nexC] == grid[curR][curC] + 1) {
						visited[nexR][nexC] = true;
						result++;
						int[] nex = {nexR, nexC}; 
						dq.add(nex);
					}
				}
			}
		}  // while 문 끝
		if (result > answer) {
			answer = result;
			answerIdx = idx;
		} else if (result == answer) {
			answer = result;
			if (answerIdx > idx) {
				answerIdx = idx;
			}
		}
	}  // bfs 함수 끝
}

