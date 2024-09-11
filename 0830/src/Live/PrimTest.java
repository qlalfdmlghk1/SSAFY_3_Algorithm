package Live;

import java.util.Arrays;
import java.util.Scanner;

public class PrimTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();                // 정점의 수
		int[][] adjMatrix = new int[V][V];   // 인접 행렬 (그래프의 간선 가중치를 저장)
		boolean[] visited = new boolean[V];  // 정점의 방문 여부를 체크하는 배열
		int[] minEdge = new int[V];          // 각 정점이 연결될 수 있는 간선 중 최소 가중치를 저장하는 배열
		
		// 인접 행렬 데이터 입력 받기
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = sc.nextInt();  // i에서 j로 가는 간선의 가중치 입력
			}
		}
		
		// 최소 간선 가중치 배열을 무한대로 초기화
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0;  // 시작 정점을 0으로 설정하고, 첫 번째 정점의 간선 가중치를 0으로 초기화
		int cost = 0;    // MST의 총 가중치를 저장할 변수
		
		int i = 0;
		for (i = 0; i < V; i++) {
			
			// step 1: 방문하지 않은 정점들 중에서 가장 작은 간선 가중치를 가진 정점 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int j = 0; j < V; j++) {
				if(visited[j]) continue;  // 이미 방문한 정점은 건너뜀
				if(min > minEdge[j]) {    // 현재 찾은 최소 가중치보다 작은 경우 업데이트
					minVertex = j;
					min = minEdge[j];
				}
			}
			
			if (minVertex == -1) break;  // 모든 정점이 MST에 포함되면 종료
			visited[minVertex] = true;   // 선택된 정점을 방문 처리
			cost += min;  // 선택된 간선의 가중치를 MST의 총 가중치에 더함
			
			// step 2: 선택된 정점에 인접한 정점들의 간선 가중치를 업데이트
			for (int j = 0; j < V; j++) {
				// 방문하지 않은 정점이면서 간선이 존재하고, 기존 최소 가중치보다 작은 경우 업데이트
				if(!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(i == V ? cost : -1);  // MST의 총 가중치를 출력, 모든 정점을 방문하지 못하면 -1 출력
	}
}

/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
*/