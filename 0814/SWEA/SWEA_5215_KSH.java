package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_KSH {
    // 전역 변수 선언
    static int result;   // 최대 점수를 저장할 변수
    static int[] score;  // 각 재료의 맛 점수를 저장할 배열
    static int[] calory; // 각 재료의 칼로리를 저장할 배열
    static int N;        // 재료의 수
    static int L;        // 제한 칼로리

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 수 입력
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            result = 0;  // 각 테스트 케이스마다 최대 점수를 초기화
            N = Integer.parseInt(st.nextToken());  // 재료의 수 입력
            L = Integer.parseInt(st.nextToken());  // 제한 칼로리 입력
            score = new int[N];   // 맛 점수 배열 초기화
            calory = new int[N];  // 칼로리 배열 초기화

            // 재료의 맛 점수와 칼로리를 입력받아 배열에 저장
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                score[i] = Integer.parseInt(st.nextToken());
                calory[i] = Integer.parseInt(st.nextToken());
            }

            // 백트래킹을 통해 최대 점수를 계산
            combination(0, 0, 0);

            // 결과를 StringBuilder에 저장
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb.toString());
    }

    // 백트래킹 메서드: 현재 점수, 현재 칼로리, 깊이(depth)를 파라미터로 받음
    public static void combination(int current_score, int current_calory, int depth) {
        // 현재 칼로리가 제한 칼로리를 초과하면 종료
        if(current_calory > L)
            return;

        // 모든 재료를 다 고려했을 경우, 최대 점수 갱신
        if(depth == N) {
            if(current_calory <= L) {
                result = Math.max(current_score, result); // 최대 점수 갱신
            }
            return;
        }

        // 현재 재료를 선택한 경우
        combination(current_score + score[depth], current_calory + calory[depth], depth + 1);

        // 현재 재료를 선택하지 않은 경우
        combination(current_score, current_calory, depth + 1);
    }
}