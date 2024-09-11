package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_6109_AnswerCode {
	static int T, n;
	static String direction;
	static int[][] grid, newGrid;
	static Stack<Integer> s1;
	static ArrayList<Integer> l1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;

		T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t < T + 1; t++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			direction = st.nextToken();

			grid = new int[n][n];
			newGrid = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb = new StringBuilder();
			sb.append("#").append(t).append("\n");

			if (direction.equals("up")) {
				for (int j = 0; j < n; j++) {
					s1 = new Stack<>();
					l1 = new ArrayList<>();
					boolean merged = false; // 합쳐진 숫자를 다시 합치지 않기 위한 플래그

					for (int i = 0; i < n; i++) {
						if (grid[i][j] == 0) continue;

						if (s1.isEmpty()) {
							s1.add(grid[i][j]);
							merged = false;
						} else if (s1.peek() == grid[i][j] && !merged) {
							l1.add(s1.pop() * 2);
							merged = true;
						} else {
							l1.add(s1.pop());
							s1.add(grid[i][j]);
							merged = false;
						}
					}
					while (!s1.isEmpty()) {
						l1.add(s1.pop());
					}

					for (int k = 0; k < l1.size(); k++) {
						newGrid[k][j] = l1.get(k);
					}
				}
			}

			else if (direction.equals("down")) {
				for (int j = 0; j < n; j++) {
					s1 = new Stack<>();
					l1 = new ArrayList<>();
					boolean merged = false;

					for (int i = n - 1; i >= 0; i--) {
						if (grid[i][j] == 0) continue;

						if (s1.isEmpty()) {
							s1.add(grid[i][j]);
							merged = false;
						} else if (s1.peek() == grid[i][j] && !merged) {
							l1.add(s1.pop() * 2);
							merged = true;
						} else {
							l1.add(s1.pop());
							s1.add(grid[i][j]);
							merged = false;
						}
					}
					while (!s1.isEmpty()) {
						l1.add(s1.pop());
					}

					for (int k = 0; k < l1.size(); k++) {
						newGrid[n - 1 - k][j] = l1.get(k);
					}
				}
			}

			else if (direction.equals("left")) {
				for (int i = 0; i < n; i++) {
					s1 = new Stack<>();
					l1 = new ArrayList<>();
					boolean merged = false;

					for (int j = 0; j < n; j++) {
						if (grid[i][j] == 0) continue;

						if (s1.isEmpty()) {
							s1.add(grid[i][j]);
							merged = false;
						} else if (s1.peek() == grid[i][j] && !merged) {
							l1.add(s1.pop() * 2);
							merged = true;
						} else {
							l1.add(s1.pop());
							s1.add(grid[i][j]);
							merged = false;
						}
					}
					while (!s1.isEmpty()) {
						l1.add(s1.pop());
					}

					for (int k = 0; k < l1.size(); k++) {
						newGrid[i][k] = l1.get(k);
					}
				}
			}

			else if (direction.equals("right")) {
				for (int i = 0; i < n; i++) {
					s1 = new Stack<>();
					l1 = new ArrayList<>();
					boolean merged = false;

					for (int j = n - 1; j >= 0; j--) {
						if (grid[i][j] == 0) continue;

						if (s1.isEmpty()) {
							s1.add(grid[i][j]);
							merged = false;
						} else if (s1.peek() == grid[i][j] && !merged) {
							l1.add(s1.pop() * 2);
							merged = true;
						} else {
							l1.add(s1.pop());
							s1.add(grid[i][j]);
							merged = false;
						}
					}
					while (!s1.isEmpty()) {
						l1.add(s1.pop());
					}

					for (int k = 0; k < l1.size(); k++) {
						newGrid[i][n - 1 - k] = l1.get(k);
					}
				}
			}

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					sb.append(newGrid[r][c]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}
}