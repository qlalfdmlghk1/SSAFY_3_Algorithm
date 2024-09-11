package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1267{
	static int T, V, E;
	static List<List<Integer>> graph;
	static int[] inDegree;
	static ArrayList<Integer> answer;
	static Deque<Integer> dq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
//			9 9
//			4 1 1 2 2 3 2 7 5 6 7 6 1 5 8 5 8 9
			st = new StringTokenizer(br.readLine().trim());  // 9 9 �Է�
			V = Integer.parseInt(st.nextToken());  // ���� ����
			E = Integer.parseInt(st.nextToken());  // ���� ����
			graph = new ArrayList<>();
			inDegree = new int[V+1];
			dq = new ArrayDeque<>();
			answer = new ArrayList<>();
			inDegree[0] = 10000;
			
			for (int i = 0; i < V+1; i++) {
				graph.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine().trim());  // 4 1 1 2 ... �Է�
			for (int e = 0; e < E; e++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
				inDegree[to] += 1;
			}
			
			for (int i = 0; i < V+1; i++) {
				if (inDegree[i] == 0) {
					dq.add(i);
				}
			}
			
			while (!dq.isEmpty()) {
				int cur = dq.pollFirst();
				answer.add(cur);
				for (int nex : graph.get(cur)) {
					inDegree[nex] -= 1;
					if (inDegree[nex] == 0) {
						dq.add(nex);
					}
				}
			}
		System.out.print("#" + t);
		for (int i = 0; i < V; i++) {
			System.out.print(" " + answer.get(i) );
		}
		}  // tc �� ��
	}
}
