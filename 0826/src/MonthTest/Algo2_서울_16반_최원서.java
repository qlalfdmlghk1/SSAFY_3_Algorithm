package MonthTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_서울_16반_최원서 {
	static int T, N, answer;
	static int[] alpha;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		alpha = new int [26];
		for (int n = 0; n < N; n++) {
			String str = br.readLine().trim();
			int len = str.length();
			for (int i = 0; i < len; i++) {
				alpha[str.charAt(i) - 'A'] += Math.pow(10, len-1-i); 
			}
		}
		Arrays.sort(alpha);
		
		int index = 25;
		int num = 9;
		int sum = 0;
		while (alpha[index] > 0) {
			sum += alpha[index] * num; 
			num--;
			index--;
		}
		System.out.println(sum);
	}
}
