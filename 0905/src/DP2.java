import java.util.Arrays;
import java.util.Scanner;

public class DP2 {
	
	// 동전의 단위가 1,4,6 원이고 동전 개수가 무제한!!!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1];
		
		D[0] = 0;  // base case 초기화
		for (int i = 1; i <= money; i++) {
			int min = D[i-1] + 1; // 1원짜리 동전 사용했을 경우와 4원짜리 동전을 사용했을 경우로 임시 최적해 저장
			if (i >= 4) min = Math.min(min, D[i-4]+1); // 1원짜리 동전 사용했을 경우와 4원짜리 동전을 사용했을 경우 최적해 비교 후 갱신
			// 1원짜리 동전 사용했을 경우와 4원짜리 동전을 사용했을 경우의 최적해와 6원짜리 동전을 사용했을 경우 비교 후 갱신
			if (i >= 6) min = Math.min(min, D[i-6]+1);
			D[i] = min;
		}
		System.out.println(Arrays.toString(D));
		System.out.println(D[money]);
	}
}
