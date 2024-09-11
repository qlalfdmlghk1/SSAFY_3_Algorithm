package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2382{
	static int T, N, M, K;
	static int[][] grid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());  // ���� ����  
			M = Integer.parseInt(st.nextToken());  // �ݸ� �ð�
			K = Integer.parseInt(st.nextToken());  // �̻��� ������ ����
			grid = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == 0 || j == 0 || i == N-1 || j == N-1) {
						grid[i][j] = -1;
					}
				}
			}
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine().trim());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i == r && j == c) {
							grid[i][j] = cnt;
							
						}
					}
				}
			}  // �ʱ� graph �����
		}  // tc �� ��
	}  // main �Լ� ��
	
	public static void border(int nexR, int nexC) {
		if (grid[nexR][nexC] == -1) {
			
		}
	}
}

	