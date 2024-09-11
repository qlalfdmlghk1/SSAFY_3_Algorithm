package SWEA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SWEA_4796 {
	static int[] mountains;
	static Deque<Integer> high, low;
	static int lowi, highi;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t < T+1; t++) {
			
			int n = sc.nextInt();
			
			high = new ArrayDeque<>();
			low = new ArrayDeque<>();  
			
			mountains = new int[n];
			for (int i = 0; i < n; i++) {
				mountains[i] = sc.nextInt(); 
			}
			

			for (int i = 1; i < n-1; i++) {
				if (mountains[i-1] < mountains[i] && mountains[i] > mountains[i+1]) {
					high.add(i);
				}
				if (mountains[i-1] > mountains[i] && mountains[i] < mountains[i+1]) {
					low.add(i);
					low.add(i);  // 2번씩 추가
				}
			}
			

			int answer = 0;
			
			// high 값만 있다면
			if (!high.isEmpty() && low.isEmpty()) {
				low.add(0);
				low.add(0);
				low.add(n-1);
				low.add(n-1);
			}

			// low & high 가 비어있지 않은데 
			if (!low.isEmpty() && !high.isEmpty()) {
				// low[0] > high[0] 이라면 -> low 에 0 추가
				if (low.getFirst() > high.getFirst()) {
					low.addFirst(0);
					low.addFirst(0);
				}
				// low[0] < high[0] 이라면 -> high 에 n-1 추가
				if (low.getLast() < high.getLast()) {
					low.addLast(n-1);
					low.addLast(n-1);
				}
			}
			
			low.pollFirst();
			low.pollLast();
			while (!low.isEmpty() && !high.isEmpty()) {

				int num = high.pollFirst();
				answer += Math.abs(low.pollFirst() - num) * Math.abs(low.pollFirst() - num);
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}