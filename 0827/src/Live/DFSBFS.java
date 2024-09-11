package Live;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DFSBFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	}
	
	public static void dfs(int cur, boolean[] visited) {
		visited[cur] = true; 
		System.out.println(cur);
		for (int i = 0; i < V; i++) {
			if (adjMatrix[cur][i] == 0 || visited[i]) continue;
			dfs(i,visited)
		}
			
		
	}
}
