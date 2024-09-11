package SWEA;

import java.util.Scanner;

// 코어의 좌표를 저장하는 pair 클래스 정의
class pair{
	int x, y;
	pair(int x, int y) { this.x = x; this.y = y; }
}

public class SWEA_1767_Sol {
	private static int T, N, size, min;
	// 전역 변수 선언
	// T: 테스트 케이스 수
	// N: 배열의 크기 (N x N)
	// size: 코어의 개수
	// min: 최소 전선 길이를 저장하는 변수
	private static int arr[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
	// arr: 프로세서 배치 및 전선 배열
	// dx, dy: 방향 벡터 (상, 하, 좌, 우 순서)
	private static pair core[];  // 코어들의 위치를 저장하는 배열
	private static boolean chk[];  // 현재 조합에서 선택된 코어를 체크하는 배열
	
	// 코어를 선택하는 조합을 만드는 함수
	public static void combination(int idx, int cnt, int R) {
		// cnt가 R과 같으면, 현재 조합에 대해 DFS를 수행
		if(cnt == R) {
			dfs(0, 0); // 선택된 코어에 대해 전선을 놓을 수 있는지 확인하는 dfs 함수 호출
			return;
		}
		// idx부터 시작해서 조합 생성
		for(int i = idx; i < size; i++) {
			chk[i] = true;  // i번째 코어를 선택
			combination(i + 1, cnt + 1, R);  // 다음 코어 선택
			chk[i] = false;  // i번째 코어 선택 해제 (백트래킹)
		}
	}
	
	// 전선 놓기를 시도하는 dfs 함수
	public static void dfs(int idx, int cnt) {
		// 모든 코어를 다 확인했다면 현재까지의 전선 길이로 최소값 갱신
		if(idx == size) {
			min = Math.min(min, cnt); // 배열 끝까지 돌렸으면 이때의 최솟값 갱신
			return;
		}
		// 현재 코어가 선택되지 않은 경우, 다음 코어로 넘어감
		if(!chk[idx]) { // 부분 집합에 포함되는 코어들만 처리
			dfs(idx + 1, cnt);
			return;
		}
		// 4방향으로 전선을 놓아보기
		for(int i = 0; i < 4; i++) {
			int x = core[idx].x, y = core[idx].y, tmp = 0;
			boolean success = false;
			// 한 방향으로 쭉 전선을 놓아보기
			while(true) {
				x += dx[i]; y += dy[i];
				if(x < 0 || x >= N || y < 0 || y >= N) { // 배열의 끝까지 도달하면 성공
					success = true;
					break;
				}
				if(arr[x][y] != 0) break; // 다른 전선이나 코어를 만나면 실패
				arr[x][y] = 2; // 전선을 놓음
				tmp++; // 전선 길이 증가
			}
			// 성공했다면 다음 코어로 이동
			if(success) dfs(idx + 1, cnt + tmp);
			// 원상태로 배열을 되돌리기 (백트래킹)
			while(true) {
				x -= dx[i]; y -= dy[i];
				if(x == core[idx].x && y == core[idx].y) break;
				arr[x][y] = 0;  // 전선 제거
			}
		}
	}
	
	// 메인 함수 (프로그램의 시작점)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();  // 테스트 케이스 수 입력 받기
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();  // 배열 크기 입력 받기
			arr = new int[N][N]; core = new pair[12]; chk = new boolean[12];
			size = 0; min = Integer.MAX_VALUE;  // 초기화
			// 배열 초기화 및 코어 위치 저장
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < N; j++) 
					arr[i][j] = sc.nextInt();
			// 가장자리에 있는 코어는 제외하고 내부 코어의 위치를 저장
			for(int i = 1; i < N - 1; i++) 
				for(int j = 1; j < N - 1; j++) 
					if(arr[i][j] == 1) 
						core[size++] = new pair(i, j);
			
			// 코어의 개수를 줄여가며 조합을 탐색
			for(int i = size; i >= 0; i--) {
				combination(0, 0, i);  // i개의 코어를 선택하는 조합 시도
				if(min < Integer.MAX_VALUE) break;  // 최소값이 갱신되면 종료
			}
			
			// 결과 출력
			System.out.println("#" + t + " " + min);
		}
	}
}
