package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static int V, E, K, u, v, w;
    
    // Node 클래스: 그래프의 노드를 표현. 인덱스와 비용을 포함.
    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());        // 정점 수
        E = Integer.parseInt(st.nextToken());        // 간선 수

        K = Integer.parseInt(br.readLine().trim());  // 시작 정점

        // 그래프를 인접 리스트로 표현. 각 정점에 대한 리스트를 초기화.
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // E개의 간선을 입력받아 그래프를 구성
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine().trim());
            u = Integer.parseInt(st.nextToken());  // 시작
            v = Integer.parseInt(st.nextToken());  // 도착
            w = Integer.parseInt(st.nextToken());  // 가중치
            graph.get(u).add(new Node(v, w));      // 간선을 그래프에 추가
        }

        // 다익스트라 알고리즘에 사용할 방문 여부 배열과 거리 배열 초기화
        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        // 초기 거리 값을 무한대로 설정, 시작 정점 K의 거리는 0으로 설정
        for (int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;

        // 다익스트라 알고리즘 수행
        for (int i = 0; i < V; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
   
            // 방문하지 않은 정점 중에서 최단 거리가 가장 짧은 정점을 찾음
            for (int j = 1; j < V + 1; j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;  // 해당 정점을 방문 처리
            
            // 선택된 정점의 인접 정점들에 대해 거리 값을 갱신
            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
