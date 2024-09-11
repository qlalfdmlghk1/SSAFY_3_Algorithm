package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ladder1_1210 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		int n = Integer.parseInt(st.nextToken());
		int[][] ladder = new int[100][100];
		int startR = 0;
		int startC = 0;
		
		for(int i = 0; i < 100; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < 100; j++) {
            	ladder[i][j]=Integer.parseInt(st.nextToken());
            }
        }
		for(int j = 0; j < 100; j++) {
        	if(ladder[99][j] == 2) {
                startR = 99;
                startC = j;
                bfs(0,j,n,ladder);
            }
        }
		
	}
	
	public static void bfs(int startR, int startC, int n, int[][] ladder) {
		Deque<int[]> dq = new LinkedList<>();
		int[] point = {startR, startC};
		boolean[][] visited = new boolean[n][n];
		// visited[startR][startC] = true;
		dq.addLast(point);
		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int curR = cur[0];
			int curC = cur[1];
			visited[curR][curC] = true;
			
			if (curR == 0) {
				System.out.println(curC);
			}
			
			int nexR = 0, nexC = 0;
			if (curR-1 >= 0 && curR-1 == 1 && visited[curR-1][nexC] == false) {
				nexR = curR-1;
				nexC = curC;
			} 
			if (curC-1 >= 0 && curC-1 == 1 && visited[curR][nexC-1] == false) {  // 위에 길이 있어도 왼쪽으로 진행하는 것이 더 우선순위
				nexR = curR;
				nexC = curC-1;
			} 
			if (curC+1 < n && curC-1 == 1 && visited[curR][nexC+1] == false) {  // 위에 길이 있어도 오른쪽으로 진행하는 것이 더 우선순위
				nexR = curR;
				nexC = curC+1;
			} 
			int[] nex = {nexR, nexC};
			visited[nexR][nexC] = true;
			dq.addLast(nex);
			
		}
	}
}
