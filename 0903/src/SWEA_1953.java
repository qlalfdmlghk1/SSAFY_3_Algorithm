import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1953 {
	static int T, N, M, R, C, L;
	static int[][] grid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		// 지하 터널 지도의 세로 크기 N, 가로 크기 M, 맨홀 뚜껑이 위치한장소의 세로 위치 R, 가로 위치 C, 그리고 탈출 후 소요된 시간 L
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			R = Integer.parseInt(br.readLine().trim());
			C = Integer.parseInt(br.readLine().trim());
			L = Integer.parseInt(br.readLine().trim());
			
			grid = new int[N][M]; 
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int m = 0; m < M; m++) {
					grid[n][m] = Integer.parseInt(st.nextToken());
					
				}
			}
		}
		
	}  // main 함수 끝
	
	public static void One(int cnt) {
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
	}

}
