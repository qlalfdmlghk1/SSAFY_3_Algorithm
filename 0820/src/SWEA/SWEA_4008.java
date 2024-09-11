package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008 {
	
	static int n;
	static int answer, minNum, maxNum;
	static int[] operator, numbers, operSpace;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
	
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t < T+1; t++) {
			minNum = Integer.MAX_VALUE;
			maxNum = Integer.MIN_VALUE;
			
			n = Integer.parseInt(br.readLine().trim());
			
			operator = new int[4];
			numbers = new int[n];
			operSpace = new int[n-1];
			
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < 4; j++) {
				operator[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				numbers[j] = Integer.parseInt(st.nextToken());
			}
			
			check(0);
			
			answer = maxNum - minNum;
			System.out.println("#" + t + " " + answer);
		}
	}
	
	public static void check(int idx) {
		// 연산자 모두 사용하였을 때
		if (idx == n-1) {
			calculation();
		}
		
		for (int i = 0; i < 4; i++) {
			// 해당 연산자를 이미 모두 사용함
			if (operator[i] == 0) {
				continue;
			}
			operator[i]--;
			operSpace[idx] = i;
			check(idx+1);
			operator[i]++;
			
		}
	}
	
	public static void calculation() {
		int num = numbers[0];
		for (int i = 0; i < n-1; i++) {
			// + 인 경우
			if (operSpace[i] == 0) {
				num += numbers[i+1];
			} else if (operSpace[i] == 1) {
				num -= numbers[i+1];
			} else if (operSpace[i] == 2) {
				num *= numbers[i+1];
			} else if (operSpace[i] == 3) {
				num /= numbers[i+1];
			}
		}
		if (maxNum < num) {
			maxNum = num;
		}
		if (minNum > num) {
			minNum = num;
		}
	}
}
