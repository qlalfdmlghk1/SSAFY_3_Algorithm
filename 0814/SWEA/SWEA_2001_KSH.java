package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_KSH {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스의 수 입력
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());   // 배열의 크기 N 입력
            int M = Integer.parseInt(st.nextToken());   // 파리채의 크기 M 입력
            int[][] board = new int[N][N]; // N x N 크기의 2차원 배열 초기화

            // 2차원 배열에 값을 입력하면서, 누적합을 계산하여 저장
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int j = 0; j < N; j++) {
                    int currentValue = Integer.parseInt(st.nextToken()); // 현재 위치의 값을 입력받음

                    // 현재 위치의 누적합을 계산
                    if (i > 0) currentValue += board[i - 1][j]; // 윗 행의 누적합 더하기
                    if (j > 0) currentValue += board[i][j - 1]; // 왼쪽 열의 누적합 더하기
                    if (i > 0 && j > 0) currentValue -= board[i - 1][j - 1]; // 중복된 영역 빼기
                    board[i][j] = currentValue; // 계산된 누적합을 현재 위치에 저장
                }
            }

            int result = 0;  // 최대 파리 수를 저장할 변수 초기화

            // M x M 크기의 파리채로 잡을 수 있는 최대 파리 수를 찾기 위한 반복문
            for(int i = M - 1; i < N; i++) {
                for(int j = M - 1; j < N; j++) {
                    int temp = board[i][j];   // 현재 위치까지의 누적합을 임시 변수에 저장

                    // 파리채의 윗부분을 제외
                    if (i - M >= 0) {
                        temp -= board[i - M][j];
                    }

                    // 파리채의 왼쪽 부분을 제외
                    if (j - M >= 0) {
                        temp -= board[i][j - M];
                    }

                    // 중복되어 제외된 부분을 다시 더해줌
                    if (i - M >= 0 && j - M >= 0) {
                        temp += board[i - M][j - M];
                    }

                    // 현재 계산된 파리 수와 기존 최대 파리 수 비교하여 갱신
                    result = Math.max(result, temp);
                }
            }

            // 결과를 StringBuilder에 저장
            sb.append("#" + t + " " + result + "\n");
        }

        // 최종 결과 출력
        System.out.println(sb.toString());
    }
}