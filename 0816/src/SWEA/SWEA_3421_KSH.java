package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3421_KSH {
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			result = 0;
			boolean[][] check = new boolean[N+1][N+1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				check[n1][n2] = true;
				check[n2][n1] = true;
			}
			find_subset(1, N+1, new boolean[N+1], check);
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void find_subset(int idx, int N, boolean[] visit, boolean[][] check) {
		if(idx == N) {  // 마지막 횟수까지 도달한다면, 
			for(int i = 1; i < N; i++) {
				for(int j = 1; j < N; j++) {
					if(visit[i] && visit[j]) {
						if(check[i][j])
							return;	
					}
				}
			}
			result++;
			return;
		}
		visit[idx] = true;
		find_subset(idx+1, N, visit, check);
		visit[idx] = false;
		find_subset(idx+1, N, visit, check);
	}
}