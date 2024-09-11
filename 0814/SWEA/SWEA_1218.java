package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		for (int t = 1; t < 11; t++) {
			Stack<Character> stack = new Stack<>();
			 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine().trim());
			String bracket = st.nextToken();
			 
			
			for (int i = 0; i < n; i++) {
				if (stack.empty()) {
					stack.add(bracket.charAt(i));
				} else if (stack.lastElement() == '(' && bracket.charAt(i) == ')') {
					stack.pop();
				} else if (stack.lastElement() == '{' && bracket.charAt(i) == '}') {
					stack.pop();
				} else if (stack.lastElement() == '[' && bracket.charAt(i) == ']') {
					stack.pop();					
				} else if (stack.lastElement() == '<' && bracket.charAt(i) == '>') {
					stack.pop();
				} else {
					stack.add(bracket.charAt(i));
				}
			}
			
			if (stack.empty()) {
				System.out.println("#" + t + " " + 1);
			} else {
				System.out.println("#" + t + " " + 0);
			}
		}
	}

}
