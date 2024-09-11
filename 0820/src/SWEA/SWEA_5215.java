package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
    static int maxScore;
    static int[] scores;
    static int[] calories;
    static int N;
    static int L;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken()); // 재료의 수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            scores = new int[N];
            calories = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0; // maxScore 초기화
            findMaxScore(0, 0, 0); // 재귀 호출로 최적 해 찾기

            sb.append("#").append(t).append(" ").append(maxScore).append("\n");
        }

        System.out.print(sb.toString());
    }

    // 재귀를 이용해 모든 재료의 조합을 탐색
    public static void findMaxScore(int index, int currentScore, int currentCalories) {
        // 모든 재료를 다 본 경우
        if (index == N) {
            if (currentCalories <= L) {
                maxScore = Math.max(maxScore, currentScore);
            }
            return;
        }

        // 재료를 선택하지 않는 경우
        findMaxScore(index + 1, currentScore, currentCalories);

        // 재료를 선택하는 경우
        findMaxScore(index + 1, currentScore + scores[index], currentCalories + calories[index]);
    }
}
