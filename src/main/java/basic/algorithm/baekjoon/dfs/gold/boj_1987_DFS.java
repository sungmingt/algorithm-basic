package basic.algorithm.baekjoon.dfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987_DFS {

    static int R,C;
    static char[][] board;
    static boolean[][] isVisited;
    static boolean[] alpha = new boolean[26];
    static int maxDistance;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        isVisited = new boolean[R][C];

        //input
        for (int i = 0; i < R; i++) {
            String s = br.readLine();

            for (int k = 0; k < C; k++) {
                board[i][k] = s.charAt(k);
            }
        }

        //같은 알파벳이 있는 칸을 두 번 이상 지날 수 없다.
        //  -> 탐색마다 해당 알파벳을 지났는지 검사해야 한다.
        //  -> alpha[] 배열 or HashSet
        //그냥 hashSet에 추가만 하면 dfs를 빠져나와서 다른 경로를 탐색할때 값이 그대로이기때문에 탐색하지 않게된다.
        //  -> visited 배열과 함께 재귀 후 초기화 필요

        //HashSet보다 배열이 훨씬 빠르다.

        isVisited[0][0] = true;
        alpha[board[0][0] - 65] = true;
        dfs(0, 0, 1);

        System.out.println(maxDistance);
    }

    static void dfs(int x, int y, int curDistance) {
        maxDistance = Math.max(maxDistance, curDistance);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dX[i];
            int nextY = y + dY[i];

            if (isMovable(nextX, nextY) && !alpha[board[nextX][nextY] - 65]) {
                isVisited[nextX][nextY] = true;
                alpha[board[nextX][nextY] - 65] = true;
                dfs(nextX, nextY, curDistance + 1);
                isVisited[nextX][nextY] = false;
                alpha[board[nextX][nextY] - 65] = false;
            }
        }
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C && !isVisited[x][y];
    }
}
