import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Stick {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		dp = new int[N+1];
		dp[1] = 2;
		dp[2] = 5;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + 2 * dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
