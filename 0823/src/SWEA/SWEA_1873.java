package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	static int T, h, w, n, r, c;
	static char d;
	static String l;
	static char[][] grid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine().trim());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			grid = new char[h][w];
			
			for (int i = 0; i < h; i++) {
				l = br.readLine().trim();
				for (int j = 0; j < w; j++) {
					grid[i][j] = l.charAt(j);
				}
			}
			
			n = Integer.parseInt(br.readLine().trim());
			
			String direction = br.readLine().trim();
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (grid[i][j] == '<' || grid[i][j] == '^' || grid[i][j] == '>' || grid[i][j] == 'v') {
						r = i;
						c = j;
					}
				}
			}  // 첫 시작 찾기 끝 
			
			for (int s = 0; s < direction.length(); s++) {
				if (isPositioning(grid[r][c])) {
					d = direction.charAt(s);
					changePosition(d, r, c);
				} else {
					shot(d, r, c);
				}
			}
			
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(grid[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}  // tc for문 끝
	}  // main 끝
	
	
	public static boolean isPositioning(char p) {
		if (p == '<' || p == '^' || p == '>' || p == 'v') {
			return true;
		} return false;
	}  // isPositioning 함수 끝
	
	
	public static void changePosition(char p, int curR, int curC) {
		if (p == 'L') {
			int nexR = curR;
			int nexC = curC-1;
			if (0 <= nexC && nexC < w) {
				grid[curR][curC] = '.';
				grid[nexR][nexC] = '<';
			} return;
		} else if (p == 'R') {
			int nexR = curR;
			int nexC = curC+1;
			if (0 <= nexC && nexC < w) {
				grid[curR][curC] = '.';
				grid[nexR][nexC] = '>';
			} return;
		} else if (p == 'U') {
			int nexR = curR-1;
			int nexC = curC;
			if (0 <= nexR && nexR < h) {
				grid[curR][curC] = '.';
				grid[nexR][nexC] = '^';
			} return;
		} else if (p == 'D') {
			int nexR = curR+1;
			int nexC = curC;
			if (0 <= nexR && nexR < h) {
				grid[curR][curC] = '.';
				grid[nexR][nexC] = 'v';
			} return;
		} 
	}  // checkPosition 함수 끝
	
	
	public static void shot(char p, int curR, int curC) {
		if (p == 'L') {
			int nexR = curR;
			int nexC = curC-1;
			while (0 <= nexC && nexC < w) {
				if (grid[nexR][nexC] == '#') {
					break;
				} else if (grid[nexR][nexC] == '*') {
					grid[nexR][nexC] = '.';
					break;
				}
				nexC = curC-1;
			} return;
		} else if (p == 'R') {
			int nexR = curR;
			int nexC = curC+1;
			while (0 <= nexC && nexC < w) {
				if (grid[nexR][nexC] == '#') {
					break;
				} else if (grid[nexR][nexC] == '*') {
					grid[nexR][nexC] = '.';
					break;
				}
				nexC = curC+1;
			} return;
		} else if (p == 'U') {
			int nexR = curR-1;
			int nexC = curC;
			while (0 <= nexR && nexR < h) {
				if (grid[nexR][nexC] == '#') {
					break;
				} else if (grid[nexR][nexC] == '*') {
					grid[nexR][nexC] = '.';
					break;
				}
				nexR = curR-1;
			} return;
		} else if (p == 'D') {
			int nexR = curR+1;
			int nexC = curC;
			while (0 <= nexR && nexR < h) {
				if (grid[nexR][nexC] == '#') {
					break;
				} else if (grid[nexR][nexC] == '*') {
					grid[nexR][nexC] = '.';
					break;
				}
				nexR = curR+1;
			} return;
		}
	}
}