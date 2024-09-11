import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643 {
	static int T, N, adjMatrix[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());
			
			adjMatrix = new int[N+1][N+1];  // 학생번호 1번부터 시작
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			}
			
			int ans = 0;  // 자신의 키를 알 수 있는 학생 수
			// 각 학생마다 자신보다 큰, 자신보다 작은 학생 각각 탐색
			for (int i = 1; i <= N; i++) {
				if (gtBFS(i)+ltBFS(i) == N-1) ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	public static int gtBFS(int start) { //자신보다 큰 학생
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adjMatrix[cur][i] != 0) {
					q.offer(i);
					visited[i] = true;
					cnt++;  // 나보다 큰 대상 카운팅
				}
			}
		}
		return cnt;
	}
	
	public static int ltBFS(int start) { //자신보다 작은 학생
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adjMatrix[i][cur] != 0) {
					q.offer(i);
					visited[i] = true;
					cnt++;  // 나보다 작은 대상 카운팅
				}
			}
		}
		return cnt;
	}
}
