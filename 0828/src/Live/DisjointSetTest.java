package Live;

import java.util.Arrays;

public class DisjointSetTest {

	static int N = 5;      // 집합의 원소 수
	static int[] parents;  // 각 원소의 부모를 저장할 배열
	
	// 모든 원소를 개별 집합으로 초기화하는 함수
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;     // 모든 원소의 부모를 자기 자신으로 설정
		}
	}
	
	// 주어진 원소 a의 루트 원소(집합 대표)를 찾는 함수
	static int findSet(int a) {
		if (a == parents[a]) return a;  // 자기 자신이 부모라면 루트 원소이므로 반환
		// 부모를 따라가며 루트 원소를 찾고, 경로 압축을 통해 부모를 루트 원소로 설정
		return parents[a] = findSet(parents[a]);	
	}
	
	// 두 원소 a와 b가 속한 집합을 합치는 함수
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;  // 두 원소가 이미 같은 집합에 속해 있다면 합칠 필요 없음
		
		// 두 원소를 하나의 집합으로 합침 (bRoot의 부모를 aRoot로 설정)
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		parents = new int[N]; // 부모 배열 초기화
		
		make();  // 각 원소를 개별 집합으로 초기화
		System.out.println(Arrays.toString(parents)); // 초기 부모 배열 출력
		System.out.println(union(0,1));               // 0과 1을 하나의 집합으로 합침
		System.out.println(Arrays.toString(parents)); // 부모 배열 출력
		System.out.println(union(2,1));               // 2와 1을 하나의 집합으로 합침
		System.out.println(Arrays.toString(parents)); // 부모 배열 출력
		System.out.println(union(3,2));               // 3과 2를 하나의 집합으로 합침
		System.out.println(Arrays.toString(parents)); // 부모 배열 출력
		System.out.println(union(4,3));               // 4와 3을 하나의 집합으로 합침
		System.out.println(Arrays.toString(parents)); // 부모 배열 출력
	} 	
}
