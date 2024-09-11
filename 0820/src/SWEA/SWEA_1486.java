package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1486 {
	static int n, b, result;
	static int[] height;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
	
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			height = new int[n];
			visited = new boolean[n];
			result = Integer.MAX_VALUE;
					
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			check(0);
			System.out.println("#" + t + " " + result);
		}
		
	}
	public static void check(int cnt) {
		// 기저 조건
		if (cnt == n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {  // 방문 되었으면
					sum += height[i];
				}
			}
			if (sum >= b) {
				int diff = sum - b;
				result = Math.min(diff, result);
			}
			return;
		}
		
		visited[cnt] = true;
		check(cnt+1);
		visited[cnt] = false;
		check(cnt+1);
	}
}
