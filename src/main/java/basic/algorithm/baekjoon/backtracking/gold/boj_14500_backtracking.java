package basic.algorithm.baekjoon.backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14500_backtracking {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int maxSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        //bfs
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                isVisited[i][k] = true;
                bfs(1, map[i][k], i, k);
                isVisited[i][k] = false;
            }
        }

        System.out.println(maxSum);
    }

    static void bfs(int depth, int sum, int x, int y) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dX[i];
            int nextY = y + dY[i];

            //depth가 2일때, 마지막 모양을 만들기 위해 현재 자리에서 두번 탐색해야 한다 -> sum과 depth만 증가 처리
            if (depth == 2) {
                if (isMovable(nextX, nextY) && !isVisited[nextX][nextY]) {
                    isVisited[nextX][nextY] = true;
                    bfs(depth + 1, sum + map[nextX][nextY], x, y);
                    isVisited[nextX][nextY] = false;
                }
            }

            if (isMovable(nextX, nextY) && !isVisited[nextX][nextY]) {
                isVisited[nextX][nextY] = true;
                bfs(depth + 1, sum + map[nextX][nextY], nextX, nextY);
                isVisited[nextX][nextY] = false;
            }
        }
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
