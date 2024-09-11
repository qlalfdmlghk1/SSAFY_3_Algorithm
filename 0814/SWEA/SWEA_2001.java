package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] graph = new int[n][n];
			
			for(int j = 0; j < n; j++) {
	            st = new StringTokenizer(br.readLine().trim());
	            for(int k = 0; k < n; k++) {
	            	graph[j][k]=Integer.parseInt(st.nextToken());
	            }
	        }
			
			int[][] newGraph = new int[n-m+1][n-m+1];
			
			for (int a = 0; a < newGraph.length; a++) {
				for (int b = 0; b < newGraph.length; b++) {
					for (int c = 0; c < m; c++) {
						for (int d = 0; d < m; d++) {
							newGraph[a][b] += graph[a+c][b+d];
						}
					}
				}
			}
			
			int answer = 0;
			for (int i = 0; i < newGraph.length; i++) {
				for (int j = 0; j < newGraph.length; j++) {
					if (newGraph[i][j] > answer) {
						answer = newGraph[i][j];
					}
				}
			}
			System.out.println("#" + (t+1) + " " + answer);
		}	
	}
}
