package MonthTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_서울_16반_최원서 {
	static int T, N, X, K, a, b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int answer = X; // 현재 간식의 위치
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine().trim());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if (a == answer) {
					answer = b;
				} else if (b == answer) { 
					answer = a;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
