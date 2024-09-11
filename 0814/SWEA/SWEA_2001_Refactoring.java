package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_Refactoring {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    int T = Integer.parseInt(br.readLine().trim());
	    
	    for(int t=1; t<=T; t++) {
	        st = new StringTokenizer(br.readLine().trim());
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        int[][] board = new int[n][n];
	        
	        for(int i = 0; i < n; i++) {
	            st = new StringTokenizer(br.readLine().trim());
	            for(int j = 0; j < n; j++) {
	                int currentValue = Integer.parseInt(st.nextToken());
	                if (i > 0) currentValue += board[i - 1][j];
	                if (j > 0) currentValue += board[i][j - 1];
	                if (i > 0 && j > 0) currentValue -= board[i - 1][j - 1];
	                board[i][j] = currentValue;
	            }
	        }
	        
	        for(int i = m-1; i < n; i++) {
	            for(int j = m-1; j < n; j++) {
	            	
	            }
	        }
	    }
	}
}