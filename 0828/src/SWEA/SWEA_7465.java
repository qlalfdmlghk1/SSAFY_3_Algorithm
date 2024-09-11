package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_7465 {
	static int T, N, M, U, V;
	static List<List<Integer>> graph;
	static boolean[] visited;
	static Deque<Integer> q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			
			for (int n = 0; n < N+1; n++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine().trim());
				U = Integer.parseInt(st.nextToken());
				V = Integer.parseInt(st.nextToken());
				graph.get(U).add(V);
				graph.get(V).add(U);
			}
			
			visited = new boolean[N+1];
			int cnt = 0;
			for (int i = 1; i < N+1; i++) {
				if (!visited[i]) {
					bfs(i, visited);
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
	
	public static void bfs(int v, boolean[]visited) {
		q = new ArrayDeque<>();
		q.add(v);
		while (!q.isEmpty()) {
			int cur = q.pollFirst();
			for (int nex : graph.get(cur)) {
				if (!visited[nex]) {
					visited[nex] = true;
					q.add(nex);
				}
			}
		}
	}

}
