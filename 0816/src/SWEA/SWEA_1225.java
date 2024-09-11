package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        for(int t = 0; t < 10; t++) {
        	StringBuilder sb = new StringBuilder();
        	int TC = Integer.parseInt(br.readLine().trim());
        	Deque<Integer> dq = new ArrayDeque<>();
        	StringTokenizer st = new StringTokenizer(br.readLine().trim()); 
        	
        	for (int i = 0; i < 8; i++) {
        		dq.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	boolean isFinished = false;
        	while (!isFinished) {
        		for (int j = 1; j <= 5; j++) {
        			int front = dq.pollFirst() - j;
        			
        			if (front <= 0) {
        				front = 0;
        				dq.addLast(front);
        				isFinished = true;
        				break;
        			}
        			dq.addLast(front);
        		}
        	}
        	sb.append('#').append(TC).append(" ");
        	for (int num : dq) {
        		sb.append(num).append(" ");
        	}
		 System.out.println(sb.toString());
        }
	}
}