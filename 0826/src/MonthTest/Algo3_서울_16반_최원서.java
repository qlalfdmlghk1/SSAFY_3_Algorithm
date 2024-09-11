package MonthTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Algo3_서울_16반_최원서 {
	static int T, N, direction, R, C, answerR, answerC;
	static char answerK;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static char[][] grid;
	static boolean[][] visited;
	static ArrayDeque<int[]> q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		grid = new char[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String line = br.readLine().trim();
			for (int c = 0; c < C; c++) {
				grid[r][c] = line.charAt(c);
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < R; c++) {
				if(grid[r][c] == 'M') {
					visited[r][c] = true;
					int[] p = {r,c};
					q.add(p);
				}
				while (!q.isEmpty()) {
					int[] cur = q.pollFirst();
					int curX = cur[0];
					int curY = cur[1];
					for (int i = 0; i < 4; i++) {
						int necX = curX + dr[i];
						int necY = curY + dc[i];
						if (!(grid[necX][necY] == '.') && !visited[necX][necY]) {
							int[] nex = {r,c};
							q.add(nex);
							visited[necX][necY] = true;
						}
					}
					for (int i = 0; i < 4; i++) {
						answerR = 2;
						answerC = 4;
						answerK = '-';
						int necX = curX + dr[i];
						int necY = curY + dc[i];
					}
				}
			}
		}
		System.out.println(answerR + " " + answerC + " " + answerK);
	}
	
	
	public static void block1(int inputDirection) {
		if (inputDirection == 1) direction = 4;
		if (inputDirection == 3) direction = 2;
	}
	public static void block2(int inputDirection) {
		if (inputDirection == 4) direction = 2;
		if (inputDirection == 1) direction = 3;
	}
	public static void block3(int inputDirection) {
		if (inputDirection == 2) direction = 3;
		if (inputDirection == 4) direction = 1;
	}
	public static void block4(int inputDirection) {
		if (inputDirection == 3) direction = 1;
		if (inputDirection == 2) direction = 4;
	}
	public static void blocka(int inputDirection) {
		if (inputDirection == 3) direction = 3;
		if (inputDirection == 4) direction = 4;
	}
	public static void blockb(int inputDirection) {
		if (inputDirection == 1) direction = 1;
		if (inputDirection == 2) direction = 2;
	}
	public static void blockc(int inputDirection) {
		if (inputDirection == 1) direction = 1;
		if (inputDirection == 2) direction = 2;
		if (inputDirection == 3) direction = 3;
		if (inputDirection == 4) direction = 4;
	}

}
