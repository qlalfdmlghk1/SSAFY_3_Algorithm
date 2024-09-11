package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2115 {
	static int T, N, M, C, maxNum, result, max1, max2;
	static int[][] grid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());  // 벌통들의 크기
			M = Integer.parseInt(st.nextToken());  // 벌통의 개수
			C = Integer.parseInt(st.nextToken());  // 꿀을 채취할 수 있는 최대 양
			
			grid = new int[N][N];
			
			for (int i = 0; i < N; i++) { 
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(Arrays.deepToString(grid));
			System.out.println("#" + t + " " +combination());
		}
	}  // main 함수 끝
	
	public static int combination() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {  // 첫 열부터 벌통 선택할 수 있는 열(M-N)까지
				maxNum = 0;  // 특정 위치에서 가능한 최대 이익을 저장
				getMaxHoney(i, j, 0, 0, 0);
				max1 = maxNum;
				
				
				maxNum = 0;
				max2 = 0;
				
				// 일꾼2가 일꾼1과 같은 행 && 다음 열부터 벌통 확인
				for (int j2 = j + M; j2 < N-M; j2++) {
					getMaxHoney(i, j2, 0, 0, 0);
					max2 = Math.max(result, maxNum);
				} 
				
				// 일꾼2가  일꾼1과 다른 행에서 && 같은 열
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						getMaxHoney(i2, j2, 0, 0, 0);
						max2 = Math.max(max2, maxNum); // 이익 최댓값으로 갱신
					}
				}
				// 일꾼1의 선택에 따라 전체 이익 갱신
				result = Math.max(result, max1 + max2);
			}
		}
		return result;
	}  // combination 함수 끝
	
	public static void getMaxHoney(int i, int j, int cnt, int sum, int benefit) {
		// 채취한 꿀이 가능한 최대 꿀 양 넘었다면
		if (sum > C) return;
		
		// 벌통 M개 선택했다면
		if (cnt == M) {
			if (maxNum < benefit) {
				maxNum = benefit;
			}
			return;
		}
		
		// 선택
		getMaxHoney(i, j + 1, cnt + 1, sum + grid[i][j], benefit + grid[i][j] * grid[i][j]);
		// 비선택
		getMaxHoney(i, j + 1, cnt + 1, sum, benefit);
	}
}