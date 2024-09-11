package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
		static int T = 10;
		static int l, start;
		static int maxPerson = 101;
		static boolean[] visited;
		static int[][] graph;
		static Queue<Integer> q;
		
	    public static void main(String[] args) throws IOException{
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	
	    	for(int t = 1; t < 11; t++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		graph = new int[maxPerson][maxPerson];
	    		q = new LinkedList<>();
	    		visited = new boolean[maxPerson];
	    		
	    		l = Integer.parseInt(st.nextToken());
	    		start = Integer.parseInt(st.nextToken());
	    		
	    		st = new StringTokenizer(br.readLine());
	    		
	    		// 연락망 입력
	    		for(int i = 0; i < l/2; i++) {
	    			int from = Integer.parseInt(st.nextToken());
	    			int to = Integer.parseInt(st.nextToken());
	    			
	    			graph[from][to] = 1;
	    		}	
	    		
	    		System.out.print("#" + t + " ");
	    		bfs(start);
	    	}
	    }
	    
	    public static void bfs(int v) {
	    	ArrayList<Integer> list = new ArrayList<>();
	    	q.offer(v);
	    	visited[v] = true; 
	    	int max = 0;
	    	
	    	while(!q.isEmpty()) {
	    		int queueSize = q.size();
	    		max = 0;
	    		
	    		for(int i = 0; i < queueSize; i++) {
					int cur = q.poll();
					for(int j = 1; j < maxPerson; j++) {
						// 연락 가능하다면 큐에 삽입하고 방문처리
						if(!visited[j] && graph[cur][j] == 1) {
							visited[j] = true;
							q.offer(j);
							max = Math.max(max, j);
						}
					}
	    		}
	    		list.add(max);
	    	}
	    	System.out.println(list.get(list.size()-2));
	    }  // bfs 함수 끝
	}