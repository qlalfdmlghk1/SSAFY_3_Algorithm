import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest {
	static long callCnt1, callCnt2;
	static long[] memo;
	
	static long fibo1(int n) {
		callCnt1++;
		if(n <= 2) return 1;
		return fibo1(n-1) + fibo1(n-2);  
	}
	
	static long fibo2(int n) {
		callCnt2++;
		if (memo[n] == -1) {
			memo[n] = fibo2(n-1) + fibo2(n-2);   
		}
		return memo[n];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new long[N+1];
		Arrays.fill(memo, -1);
		memo[1] = memo[2] = 1; // base case 초기화
		
		System.out.println("메모 버전 :" + fibo2(N));
		System.out.println("메모 버전 수행횟수:" + callCnt2);
		
		System.out.println("메모하지 않는 버전 :" + fibo1(N));
		System.out.println("메모하지 않는 버전 수행횟수 :" + callCnt1);
		
	}
	
	

}
