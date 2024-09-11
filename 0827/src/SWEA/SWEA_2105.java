package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105 {
	static int T, N;
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {-1, 1, -1, 1};
	static int[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			graph = new int[N][N];
			N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}
	
	private static void dfs(int si, int sj, int i, int j, int cnt, int dir) {
        if (i == si + 1 && j == sj - 1) {
            if (cnt == 2)
                return;

            ans = Math.max(ans, cnt);
            return;
        }

        visited[i][j] = true;
        dessert[map[i][j]] = true;

        for (int d = dir; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || ni > N - 1 || nj < 0 || nj > N - 1 || visited[ni][nj] || dessert[map[ni][nj]]) continue;

            dfs(si, sj, ni, nj, cnt + 1, d);
        }

        visited[i][j] = false;
        dessert[map[i][j]] = false;
    }
}
