import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952 {
	static int T, day, month, threeMonth, year;
	static int[] schedule, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			threeMonth = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine().trim());
			schedule = new int[12];
			dp = new int[13];       // 1월부터 i월까지 수영장을 이용했을 때의 최소 비용 저장
			
			for (int i = 0; i < 12; i++) schedule[i] = Integer.parseInt(st.nextToken());
			for (int m = 1; m <= 12; m++) {
				// 1일 이용권을 사용하는 경우 : 이전 달까지의 최소 비용 + i월의 일수 * 1일 이용권 비용
				dp[m] = dp[m-1] + schedule[m-1] * day;
				
				// 1달 이용권을 사용하는 경우 : 이전 달까지의 최소 비용 + 1달 이용권 비용
				dp[m] = Math.min(dp[m], dp[m-1] + month);
				
				// 3달 이용권을 사용하는 경우
				if (m >= 3) {
					dp[m] = Math.min(dp[m], dp[m-3] + threeMonth);
				} else {
					dp[m] = Math.min(dp[m], threeMonth);  // 1월이나 2월일 때 3달 이용권을 사용할 경우
				}
			}
			
			// 1년 이용권과 비교
			int answer = Math.min(dp[12], year);
			
			// 결과 출력
			System.out.println("#" + t + " " + answer);
		}
	}
}
