package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1251 {
	static int T, N, X, Y, V, result;
	static double E;
	static int[] parents;
	static long[] islandX;
	static long[] islandY;
	static Edge[] edges;
	
	static void make() {
		parents = new int[N];
		for (int i = 1; i < N; i++) {
			parents[i] = i;	
			}
		}

	static int findSet(int a) {
		// 
		if (parents[a] != a) return parents[a] = findSet(parents[a]);
		return a;  
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
//		if (aRoot == bRoot) return false; // �̹� ���� �����̶� ��ĥ �ʿ� ����
		
		// ���ǻ� a ���տ� b ������ ���� (������ ũ�⿡ ���� ���̵��� ó��)
		if (aRoot > bRoot) {
			parents[aRoot] += parents[bRoot];
			parents[bRoot] = aRoot;
		} else {
			parents[bRoot] += parents[aRoot];
			parents[aRoot] = bRoot;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine().trim()); // ���� ����
			make();
			islandX = new long[N];
			islandY = new long[N];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				islandX[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				islandY[i] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine().trim()); // ȯ�� �δ� ���� �Ǽ�
			
			
			
			edges = new Edge[N * (N-1) /2];  // ���� ���� : ��� ���� �߰��ؾ� ��
			
			int index = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					long distance = (long) (Math.pow((islandX[i] - islandX[j]), 2) + Math.pow((islandY[i] - islandY[j]), 2));  // ������ �� ���ϴϱ�
					edges[index++] = new Edge(i, j, distance);
				}
			}
			Arrays.sort(edges);  // �Ÿ� ª�� ������ ����

//			double result = 0.0;
			for (Edge edge : edges) {
				if (findSet(edge.start) != findSet(edge.end)) {
					union(edge.start, edge.end);
					result += edge.distance;
				}
			}
			System.out.println("#" + t + " " + result);
		}  // tc �� ��
	}  // main �Լ�
	
	static class Edge implements Comparable<Edge> {  // distance �������� ����
		int start, end;
		long distance;

		public Edge(int start, int end, long distance) {
			super();
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Edge o) {  // ���� ���� ����
			return Long.compare(this.distance, o.distance);
		}
	}
}
