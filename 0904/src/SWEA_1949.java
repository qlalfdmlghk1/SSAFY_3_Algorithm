import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
 
public class SWEA_1949 {
    static int T, N, K, answer;
    static int[][] mountain;
    static int[][] mountainCnt;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static List<int[]> starts;
    static boolean[][] visited;
     
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
             
            mountain = new int[N][N];
            starts = new ArrayList<>();
            answer = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    mountain[i][j] = Integer.parseInt(st.nextToken());
                }
            }  // 그래프 그리기 끝
             
            int startHeight = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mountain[i][j] > startHeight) startHeight = mountain[i][j]; 
                }
            }
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mountain[i][j] == startHeight) {
                        starts.add(new int[]{i,j});
                    }
                }
            }
             
            for (int[] s : starts) {
                int startR = s[0];
                int startC = s[1];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k <= K; k++) {
                            if (mountain[i][j] - k >= 0) {
                                mountain[i][j] -= k;
                                int res = BFS(startR,startC);
                                if (answer < res) answer = res;
                                mountain[i][j] += k;
                            }
                        }       
                    }
                }
            }
            System.out.println("#" + t + " " + answer);
        }  // tc 문 끝 
    }  // main 문 끝 
 
    public static int BFS(int r, int c) {
        Deque<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][N];
        mountainCnt = new int[N][N];
        int cnt = 1;
        int[] start = {r,c};
        visited[r][c] = true;
        mountainCnt[r][c] = 1;
        q.add(start);
         
        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int curR = cur[0];
            int curC = cur[1];
            for(int i = 0; i < 4; i++) {
                int nexR = curR + dr[i];
                int nexC = curC + dc[i];
                if (0 <= nexR && nexR < N && 0 <= nexC && nexC < N) {
                    if (mountain[curR][curC] > mountain[nexR][nexC]) {
                        if (mountainCnt[nexR][nexC] == 0) {
                            int[] nex = {nexR, nexC};
                            mountainCnt[nexR][nexC] = mountainCnt[curR][curC] +1;
                            if (cnt < mountainCnt[nexR][nexC]) cnt = mountainCnt[nexR][nexC];
                            q.add(nex);
                        }
                        else if (mountainCnt[nexR][nexC] > 0) {
                            int[] nex = {nexR, nexC};
                            if (mountainCnt[nexR][nexC] < mountainCnt[curR][curC] + 1) {
                                mountainCnt[nexR][nexC] = mountainCnt[curR][curC] +1;
                                if (cnt < mountainCnt[nexR][nexC]) cnt = mountainCnt[curR][curC] + 1;
                                q.add(nex);
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}