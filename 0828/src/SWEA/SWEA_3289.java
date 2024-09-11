package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	static int T, N, M, x, y, c;
    static int [] parents;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
         
        T = Integer.parseInt(br.readLine().trim());
         
       for (int t = 1; t < T+1; t++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			
			sb.append("#").append(t).append(" ");
			for (int i = 1; i < N+1; i++) {
        		parents[i] = i;
    		}
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine().trim());
				c = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
	
				
                
				if (c == 0) {
					union(x,y);
				} else if (c == 1) {
					if(findSet(x) == findSet(y)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb);
		}  // tc �� ��
    }
   
     
    static int findSet(int a) {
        if (a != parents[a]) parents[a] = findSet(parents[a]);  // �ڽ��� �ڽ��� �θ� -> ��Ʈ ���
        return parents[a];
    }
     
   static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
//		if (aRoot == bRoot) return false;  // ��  ������ ��ǥ�ڰ� ������ �̹� ���� ����
			
		// aRoot �� bRoot�� ��� -> �� ���� ��ġ��
//		parents[bRoot] = aRoot;
//		return true;
		if (aRoot > bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
	}
}