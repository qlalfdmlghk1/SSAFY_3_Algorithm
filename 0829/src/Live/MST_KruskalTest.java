package Live;

import java.util.Arrays;
import java.util.Scanner;

public class MST_KruskalTest {
	static int V;          // 정점의 수
	static int[] parents;  // 유니온 파인드를 위한 부모 배열

	// 모든 정점을 개별 집합으로 초기화하는 함수
	static void make() {
		parents = new int[V];
		for(int i = 0; i < V; i++) {
			parents[i] = -1; // 초기에는 모든 정점이 개별 집합을 가리키도록 설정
		}  // 또는 Arrays.fill(parents, -1);로 초기화 가능
	}
	
	// 주어진 원소 a의 루트(대표) 원소를 찾는 함수
	static int findSet(int a) {
		if (parents[a] < 0) return a; // 음수 값이면 자신이 루트 원소임을 의미
		// 경로 압축 기법을 사용하여 루트 원소를 찾고 부모를 루트로 설정
		return parents[a] = findSet(parents[a]);
	}
	
	// 두 집합을 합치는 함수
	static boolean union(int a, int b) {
		int aRoot = findSet(a); // a의 루트 찾기
		int bRoot = findSet(b); // b의 루트 찾기
		if (aRoot == bRoot) return false; // 이미 같은 집합에 속해 있으면 합칠 필요 없음

		// 두 집합을 합칠 때, 더 큰 집합의 루트를 작은 집합의 루트로 설정
		parents[aRoot] += parents[bRoot]; // 집합 크기 갱신
		parents[bRoot] = aRoot; // bRoot를 aRoot에 연결
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); // 정점의 수 입력
		int E = sc.nextInt(); // 간선의 수 입력
		
		Edge[] edges = new Edge[E]; // 간선 배열 초기화
		for (int i = 0; i < E; i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()); // 각 간선 정보 입력
		}
		Arrays.sort(edges); // 간선을 가중치 기준으로 오름차순 정렬
		make();  // 유니온 파인드를 위한 초기화 작업
		int cnt = 0, cost = 0; // 간선 수와 총 비용 초기화
		for (Edge edge: edges) {
			if (union(edge.start, edge.end)) { // 간선 연결 시도
				cnt++;
				cost += edge.weight; // 연결된 간선의 가중치를 비용에 추가
				if (cnt == V-1) break;  // 모든 정점이 연결되면 종료 (V-1개의 간선이 연결되면 MST 완성)
			}
		}
		System.out.println(cost); // 최소 신장 트리의 총 가중치 출력
	}
	
	// 간선 클래스를 정의하고, 비교를 위한 인터페이스 구현
	static class Edge implements Comparable<Edge>{
		int start, end, weight; // 간선의 시작점, 끝점, 가중치
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight); // 가중치 기준으로 간선 비교
		}
		
	}
}

/* 
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1 
 */
