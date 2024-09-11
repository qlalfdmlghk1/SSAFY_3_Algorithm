import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2117 {
	static int T, N, M;
	static int[][] grid;
	static List<int[]> houses;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			grid = new int[N][N];
			houses = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (grid[i][j] == 1) houses.add(new int[]{i,j});
				}
			}
			
			int cnt = 0;
			int answer = 0;
			
			for (int k = 1; k < 22; k++) {  // 한 변의 길이
//			for (int k = 1; k < N+2; k++) {  // 한 변의 길이
				int price = (int) (Math.pow(k, 2) + Math.pow(k-1, 2));
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						cnt = 0;
						for (int[] h : houses) {  // i,j 는 마름모의 중심의 좌표
							// 한 변의 길이가 k 미만인 원 안에 있다면 해당 마름모 안에 있다는 것
							if ((Math.abs(h[0] - i) + Math.abs(h[1] - j)) < k) {  
								cnt++;
							}
						}
						if (cnt > answer && (cnt * M - price) >= 0) {
							answer = cnt;
						}
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}  // tc 문 끝
	}

}
