package Live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Input {

	// BufferedReader, StringBuilder, StringTokenizer
	public static void main(String[] args) throws IOException {
		// 이 2줄은 암기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String a = in.readLine();   // 한 줄 받기 -> readLine()
		System.out.println(a);
		
		// 문장 입력 받아서 한글자씩 출력
		char[] ch = in.readLine().toCharArray();
		for (char c : ch) {
			System.out.println(c);
		}

		// 띄어쓰기로 구분된 2개의 숫자를 i,j에 입력 받음 
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int i = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(st.nextToken());
		System.out.println(i+"//"+j);
	}

}
