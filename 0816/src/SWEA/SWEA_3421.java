package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3421 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t < T+1; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine().trim());
        	int n = Integer.parseInt(st.nextToken());  // n : 사용할 수 있는 재료
        	int m = Integer.parseInt(st.nextToken());  // m : 궁합이 맞지 않는 쌍의 개수
        	
        	boolean[][] check = new boolean[n+1][n+1];
        	for (int i = 0; i < m; i++) {
        		st = new StringTokenizer(br.readLine().trim());  // st 는 생길 때마다 새로 생성해줘야 되나보다.
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		check[a][b] = true;
        		check[b][a] = true;
        	}
        }
        
        public static void findSubset(int idx, int n, boolean visited, boolean check) {
        	if (idx == n) {
        		for (int i = 1; i < n; i++) {
        			for (int j = 1; j < n; j++) {
        				if (visited[i] && visited[j]) {
        					
        				}
        			}
        		}
        	}
        }

}
