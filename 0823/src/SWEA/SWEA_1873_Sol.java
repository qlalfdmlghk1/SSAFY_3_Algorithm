package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_Sol {
    // 전역 변수 선언
    static int T, H, W, N, r, c; // T: 테스트 케이스 수, H: 맵 높이, W: 맵 너비, N: 명령어 수, r: 전차의 현재 행, c: 전차의 현재 열
    static char[][] map; // 게임 맵
    static char direction; // 전차가 바라보는 방향
    static String commands; // 사용자가 입력한 명령어들
    
    // 이동 방향을 위한 배열 (위, 아래, 왼쪽, 오른쪽 순서)
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력 받기
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); // 맵 높이
            W = Integer.parseInt(st.nextToken()); // 맵 너비
            
            map = new char[H][W]; // 맵 초기화
            
            // 맵 정보 입력 받기
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    // 전차의 초기 위치와 방향 찾기
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        r = i; // 전차의 행 위치
                        c = j; // 전차의 열 위치
                        direction = map[i][j]; // 전차의 방향
                    }
                }
            }
            
            N = Integer.parseInt(br.readLine().trim()); // 명령어의 수 입력 받기
            commands = br.readLine(); // 명령어들 입력 받기
            
            // 명령어들을 하나씩 처리
            for (int i = 0; i < N; i++) {
                char command = commands.charAt(i); // 현재 명령어
                if (command == 'U') {
                    move(0, '^'); // 위쪽 이동 시도
                } else if (command == 'D') {
                    move(1, 'v'); // 아래쪽 이동 시도
                } else if (command == 'L') {
                    move(2, '<'); // 왼쪽 이동 시도
                } else if (command == 'R') {
                    move(3, '>'); // 오른쪽 이동 시도
                } else if (command == 'S') {
                    shoot(); // 포탄 발사
                }
            }
            
            // 최종 맵 상태 출력
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                System.out.println(map[i]); // 맵의 각 행을 출력
            }
        }
    }
    
    // 전차를 이동시키는 함수
    public static void move(int dir, char newDir) {
        direction = newDir; // 새로운 방향으로 전차 방향 갱신
        map[r][c] = newDir; // 맵에서 전차 방향 갱신
        int newR = r + dr[dir]; // 새로운 행 위치 계산
        int newC = c + dc[dir]; // 새로운 열 위치 계산
        
        // 이동 가능하다면 이동 (맵 안에 있고 평지일 때)
        if (newR >= 0 && newR < H && newC >= 0 && newC < W && map[newR][newC] == '.') {
            map[r][c] = '.'; // 전차가 원래 있던 위치를 평지로 변경
            r = newR; // 새로운 행 위치 갱신
            c = newC; // 새로운 열 위치 갱신
            map[r][c] = direction; // 전차의 새로운 위치 갱신
        }
    }
    
    // 포탄을 발사하는 함수
    public static void shoot() {
        int dir = -1;
        // 현재 전차의 방향에 따라 발사 방향 설정
        if (direction == '^') dir = 0;
        else if (direction == 'v') dir = 1;
        else if (direction == '<') dir = 2;
        else if (direction == '>') dir = 3;
        
        int newR = r + dr[dir]; // 포탄이 나아갈 행 위치
        int newC = c + dc[dir]; // 포탄이 나아갈 열 위치
        
        // 포탄이 맵 안에서 벽에 부딪힐 때까지 반복
        while (newR >= 0 && newR < H && newC >= 0 && newC < W) {
            if (map[newR][newC] == '#') { // 강철 벽에 부딪히면 포탄 소멸
                break;
            } else if (map[newR][newC] == '*') { // 벽돌 벽에 부딪히면 벽 파괴
                map[newR][newC] = '.';
                break;
            }
            newR += dr[dir]; // 포탄이 계속 이동
            newC += dc[dir];
        }
    }
}
