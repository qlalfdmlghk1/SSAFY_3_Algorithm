package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
	
	static int N, L;
	static int[] taste, calorie;
	static int maxScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder(); 
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			// 여기서 배열을 초기화합니다.
			taste = new int[N];
			calorie = new int[N];
			maxScore = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());    // 맛 점수  
				calorie[i] = Integer.parseInt(st.nextToken());  // 칼로리
			}
			
			// 백트래킹을 통해 최대 점수를 찾는다.
			BT(0, 0, 0);
			sb.append("#").append(t).append(" ").append(maxScore).append("\n");
		}

		System.out.print(sb.toString());
	}
	
	public static void BT(int idx, int currentTaste, int currentCalorie) {
		// 칼로리가 제한을 초과하면 종료
		if (currentCalorie > L) {
			return;
		}
		
		// 마지막 재료까지 탐색한 경우 최대 맛 점수 갱신
		if (idx == N) {
			maxScore = Math.max(maxScore, currentTaste);
			return;
		}
		
		// 현재 재료를 선택하지 않는 경우
		BT(idx + 1, currentTaste, currentCalorie);
		
		// 현재 재료를 선택하는 경우
		BT(idx + 1, currentTaste + taste[idx], currentCalorie + calorie[idx]);
	}
}
