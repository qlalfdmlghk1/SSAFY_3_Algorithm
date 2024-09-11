import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2477 {
	static int T, N, M, K, A, B, a1, b1, t1, t2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(br.readLine().trim());  // 접수 창고
			M = Integer.parseInt(br.readLine().trim());  // 정비 창구 번호
			K = Integer.parseInt(br.readLine().trim());
			A = Integer.parseInt(br.readLine().trim());
			B = Integer.parseInt(br.readLine().trim());
			
			a1 = Integer.parseInt(br.readLine().trim());
			b1 = Integer.parseInt(br.readLine().trim());
			
			st = new StringTokenizer(br.readLine().trim());
			t1 = Integer.parseInt(br.readLine().trim());
			t2 = Integer.parseInt(br.readLine().trim());
			
			
		}
	}

}
