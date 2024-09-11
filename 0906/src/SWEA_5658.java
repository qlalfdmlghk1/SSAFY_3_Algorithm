import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_5658 {
	static int T, N, K;
	static Deque<Integer> q;
	static String numbers[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());  // N자리 숫자를 문자열 배열로 분리하여 저장
			K = Integer.parseInt(st.nextToken());
			String numbers[] = br.readLine().split("");
			
			// 중복을 허용하지 않으면서 내림차순으로 정렬되는 TreeSet 사용
			TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
			
			for (int i = 0; i < N/4; i++) {
				String tmp = numbers[N-1];
				for(int j = N-1; j > 0; j--) {
					numbers[j] = numbers[j-1];
				}
				numbers[0] = tmp;
				
				// 각 변환된 숫자를 4등분하여 TreeSet에 추가 (한 번의 회전마다 4개의 수를 만들어냄)
				for (int j = 0; j < numbers.length; j += N/4) {
					StringBuilder sb = new StringBuilder();
					// N/4 길이 문자열로 만들고 TreeSet에 추가
					for (int k = j; k < j+(N/4); k++) {
						sb.append(numbers[k]);
					}
					set.add(sb.toString());  // TreeSet에 추가 (중복 자동 제거 및 내림차순 정렬)
				}
			}
			// set에 저장된 값들을 배열로 변환
			String answer[] = set.toArray(new String[set.size()]);
			// 16진수로 저장된 값을 10진수로 변환하여 출력
			System.out.println("#" + t + " " + Long.parseLong(answer[K-1],16));
		}
	}

}
