package MonthTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_서울_16반_최원서_Sol {
	static int T, N, answer;
	static String[] words;
	
	public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      
      int[] nums = new int[26]; // A B C D E F G ...
      
      for(int i = 0; i < N; i++) {
         String str = br.readLine().trim();
         int len = str.length();
         for(int j = 0; j < len; j++) {
            nums[str.charAt(j) - 'A'] += Math.pow(10, len-1-j); 
         }
      }
      Arrays.sort(nums);
      int ans = 0;
      for(int i = 0; i < 10; i++) {
         ans += i * nums[16 + i];
      }
      System.out.println(ans);
   }
}
