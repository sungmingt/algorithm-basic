package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1890_DP {

    static int N;
    static int[][] map;
    static long[][] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < N; k++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][k] = input;

                //방문하지 않았으면 -1, 경로의 수가 0이면 0을 그대로 출력해서 경우의 수가 0이더라도 재귀를 반복하지 않도록!
                dp[i][k] = -1;
            }
        }

        System.out.println(doDP(0,0));
    }

    static long doDP(int x, int y) {
        //도착했을 경우
        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        //방문한 적 있는 경우
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        //방문한 적 없음 -> 0으로 초기화
        dp[x][y] = 0;

        int moveDistance = map[x][y];

        //오른쪽으로 이동 가능한 경우
        if (isMovable(x + moveDistance, y)) {
            dp[x][y] += doDP(x + moveDistance, y);
        }

        //아래로 이동 가능한 경우
        if (isMovable(x, y + moveDistance)) {
            dp[x][y] += doDP(x, y + moveDistance);
        }

        return dp[x][y];
    }

    static boolean isMovable(int x, int y) {
        return x < N && y < N;
    }
}
