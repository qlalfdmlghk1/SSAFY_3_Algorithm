package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1767 {
	static int T, N, answer, cnt, len, nexR, nexC;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	// https://evecomcom.tistory.com/25
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				graph = new int[N][N];
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}  // 그래프 완성
			
			answer = 0;  // 전원이 연결된 core의 수가 가장 많고, 연결한 전선 길이의 합이 가장 작은 경우
			cnt = 0;  // 전원이 연결된 core의 수
			len = 0;  // 연결한 전선 길이의 합
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if (graph[i][j] == 1) {
						
							
						}
					}
				}
			}
				
		}  // main 함수 끝
	
	public static void dfs(int cnt, int connect, int line) {
		if (cnt == count) {
			if (connect > maxPower) 
		}
		
		for (int d = 0; d < 4; d++) {
			for (int k = 0; k < N; k++) {
				nexR = r + k * dr[d];
				nexC = c + k * dc[d];
				if (nexR < 0 || nexR > N-1 || nexC < 0 || nexC > N-1) {  // 경계에 도착하면 cnt++ 해주고 break
					nexR = r;
					nexC = c;
					int num = 0;  // 이거 num 뭔데?
				} 
				while (true) {
					nexR += dr[d];
					nexC += dc[d];
					if (nexR < 0 || nexR > N-1 || nexC < 0 || nexC > N-1) {  // 경계에 도착하면 cnt++ 해주고 break
						dfs(cnt+1, connect+1, line+num); break
					}
				}
			}
 			
		} 
	} 
}
