import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135 {
	static int N, M, D, answer;
	static int[] archer;
	static int[][] grid, copyGrid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());  // 행의 수
		M = Integer.parseInt(st.nextToken());  // 열의 수
		D = Integer.parseInt(st.nextToken());  // 궁수의 공격 거리 제한
		
		grid = new int[N][M];  // 크기를 N*M으로 설정
		copyGrid = new int[N][M];
		archer = new int[3];   // 궁수의 위치를 저장하는 배열
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				copyGrid[i][j] = Integer.parseInt(st.nextToken());
				grid[i][j] = copyGrid[i][j];
			}
		}
		
		combination(0, 0, archer);   // 궁수 위치 지정
		System.out.println(answer);
	}
	
	public static void combination(int start, int cnt, int[] archer) {
		if (cnt == 3) {
			start();   // 그리드 원상 복귀
			attack(archer);  // 공격 시뮬레이션 실행
			return;
		}
		for (int i = start; i < M; i++) {  // 인덱스가 0부터 시작하도록 수정
			archer[cnt] = i;  // 궁수 위치 지정
			combination(i + 1, cnt + 1, archer);  // 재귀 호출로 조합 생성
		}
	}
	
	// 그리드를 원상태로 복구하는 함수
	public static void start() {
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
				copyGrid[i][j] = grid[i][j];  // 그리드를 복사
			}
		}
	}
	
	// 두 좌표 사이의 거리를 계산하는 함수
	public static int distance(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);  // 맨해튼 거리 계산
	}
	
	// 공격 시뮬레이션 실행
	public static void attack(int[] archer) {
		int cnt = 0;   // 적을 처치한 횟수를 저장하는 변수
		for (int n = 0; n < N; n++) {
            boolean[][] visited = new boolean[N][M];  // 방문 체크 배열
            for (int i = 0; i < 3; i++) {
                int archerX = archer[i];
                int minD = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;

                // 모든 적을 대상으로 가장 가까운 적 탐색
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (copyGrid[j][k] == 1) {  // 적이 있을 때
                            int distance = distance(k, archerX, j, N);  // 궁수와 적의 거리 계산
                            if (distance < minD) {  // 더 가까운 적이 있으면 갱신
                                minD = distance;
                                minX = k;
                                minY = j;
                            } else if (distance == minD) {  // 거리가 같을 때는 X좌표가 더 작은 적 선택
                                if (k < minX) {
                                    minX = k;
                                    minY = j;
                                }
                            }
                        }
                    }
                }
                
                // 가장 가까운 적이 공격 가능 거리 내에 있을 경우
                if (minD <= D) {
                    visited[minY][minX] = true;  // 해당 적을 공격
                }
            }
            
            // 적을 제거하고 카운트 증가
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) {
                    	copyGrid[i][j] = 0;
                        cnt++;  // 적을 처치한 횟수 증가
                    }
                }
            }
            
            // 한 라운드가 끝날 때 적을 아래로 한 칸씩 이동
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    if (i == 0) {
                        copyGrid[i][j] = 0;  // 맨 윗줄은 빈칸으로 처리
                    } else {
                        copyGrid[i][j] = copyGrid[i - 1][j];  // 한 칸 아래로 이동
                    }
                }
            }
        }
        answer = Math.max(cnt, answer);  // 최대 처치한 적 수 갱신
    }
}
