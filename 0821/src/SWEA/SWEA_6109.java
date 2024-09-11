package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_6109 {
	static int T,n;
	static String direction;
	static int[][] grid, newGrid;
	static Stack<Integer> s1;
	static ArrayList<Integer> l1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t < T+1; t++) {
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
			} // for 문 끝
			
			System.out.println("#" + t);
			sb = new StringBuilder();
			
			// 방향 : up
			if (direction.equals("up")) {
				for (int j = 0; j < n; j++) {
					s1 = new Stack<>();
					l1 = new ArrayList<>();
//					System.out.println(j + "번째 열");
					for (int i = 0; i < n; i++) {
						if (grid[i][j] == 0) continue;
						
						if (s1.isEmpty()) {    // 스택이 비어있다면
							s1.add(grid[i][j]);
						} else if (s1.peek() == grid[i][j]) {  // 두 숫자가 같다면
							l1.add(s1.pop() * 2);
						} else if (s1.peek() != grid[i][j]) {  // 두 숫자가 다르다면
							l1.add(s1.pop());
							s1.add(grid[i][j]);
						} 
						
//						System.out.println("s1 : " + s1.toString());
//						System.out.println("l1 : " + l1.toString());
					}
					while (!s1.isEmpty()) {
						l1.add(s1.pop());
					}
					
//					System.out.println("최종 : " + l1.toString());
					
					for (int k = 0; k < l1.size(); k++) {
						newGrid[k][j] = l1.get(k);
					}
				}
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						sb.append(newGrid[r][c]).append(" ");
					}
					sb.append("\n");
				}
				System.out.print(sb.toString());
			}  // up for 문 끝
			
			
			// 방향 : down
			else if (direction.equals("down")) {
				for (int j = 0; j < n; j++) {
					s1 = new Stack<>();
					l1 = new ArrayList<>();
//					System.out.println(j + "번째 열");
					for (int i = n-1; i >= 0; i--) {
						if (grid[i][j] == 0) continue;
						
						if (s1.isEmpty()) {    // 스택이 비어있다면
							s1.add(grid[i][j]);
						} else if (s1.peek() == grid[i][j]) {  // 두 숫자가 같다면
							l1.add(s1.pop() * 2);
						} else if (s1.peek() != grid[i][j]) {  // 두 숫자가 다르다면
							l1.add(s1.pop());
							s1.add(grid[i][j]);
						} 
						
//						System.out.println("s1 : " + s1.toString());
//						System.out.println("l1 : " + l1.toString());
					}
					while (!s1.isEmpty()) {
						l1.add(s1.pop());
					}
					
//					System.out.println("최종 : " + l1.toString());
					
					for (int k = 0; k < l1.size(); k++) {
						newGrid[n-1-k][j] = l1.get(k);
					}
				}
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						sb.append(newGrid[r][c]).append(" ");
					}
					sb.append("\n");
				}
				System.out.print(sb.toString());
			}  // down for 문 끝
						
			
			// 방향 : left
			else if (direction.equals("left")) {
				for (int i = 0; i < n; i++) {
					s1 = new Stack<>();
					l1 = new ArrayList<>();
//					System.out.println(i + "번째 행");
					for (int j = 0; j < n; j++) {
						if (grid[i][j] == 0) continue;
						
						if (s1.isEmpty()) {    // 스택이 비어있다면
							s1.add(grid[i][j]);
						} else if (s1.peek() == grid[i][j]) {  // 두 숫자가 같다면
							l1.add(s1.pop() * 2);
						} else if (s1.peek() != grid[i][j]) {  // 두 숫자가 다르다면
							l1.add(s1.pop());
							s1.add(grid[i][j]);
						} 
						
//						System.out.println("s1 : " + s1.toString());
//						System.out.println("l1 : " + l1.toString());
					}
					while (!s1.isEmpty()) {
						l1.add(s1.pop());
					}
					
//					System.out.println("최종 : " + l1.toString());
					
					for (int k = 0; k < l1.size(); k++) {
						newGrid[i][k] = l1.get(k);
					}
				}
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						sb.append(newGrid[r][c]).append(" ");
					}
					sb.append("\n");
				}
				System.out.print(sb.toString());
			}  // left for 문 끝
			
			
			// 방향 : right
			else if (direction.equals("right")) {
				for (int i = 0; i < n; i++) {
					s1 = new Stack<>();
					l1 = new ArrayList<>();
//					System.out.println(i + "번째 열");
					for (int j = n-1; j >= 0; j--) {
						if (grid[i][j] == 0) continue;
						
						if (s1.isEmpty()) {    // 스택이 비어있다면
							s1.add(grid[i][j]);
						} else if (s1.peek() == grid[i][j]) {  // 두 숫자가 같다면
							l1.add(s1.pop() * 2);
						} else if (s1.peek() != grid[i][j]) {  // 두 숫자가 다르다면
							l1.add(s1.pop());
							s1.add(grid[i][j]);
						} 
						
//						System.out.println("s1 : " + s1.toString());
//						System.out.println("l1 : " + l1.toString());
					}
					while (!s1.isEmpty()) {
						l1.add(s1.pop());
					}
					
//					System.out.println("최종 : " + l1.toString());
					
					for (int k = 0; k < l1.size(); k++) {
						newGrid[i][n-1-k] = l1.get(k);
					}
				}
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						sb.append(newGrid[r][c]).append(" ");
					}
					sb.append("\n");
				}
				System.out.print(sb.toString());
			}  // right for 문 끝
		}
	}
}
