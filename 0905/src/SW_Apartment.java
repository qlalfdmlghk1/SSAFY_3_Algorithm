import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Apartment {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		dp = new int[N+1];
		dp[1] = 2;
		dp[2] = 3;
		
		for (int i = 3; i < N+1; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		System.out.println(dp[N]);
	}

}
