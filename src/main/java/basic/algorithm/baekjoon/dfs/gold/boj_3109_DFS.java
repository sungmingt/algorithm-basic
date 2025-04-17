package basic.algorithm.baekjoon.dfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3109_DFS {

    //greedy + dfs

    static int R, C;
    static char[][] map;
    static boolean[][] isVisited;
    static int pipeLineCnt;
    static int[] dX = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];

        //input
        for (int i = 0; i < R; i++) {
            String s = br.readLine();

            for (int k = 0; k < C; k++) {
                map[i][k] = s.charAt(k);
            }
        }

        //각 행의 첫번째 열이 모두 가스관이다. 즉, 각 행의 첫번째 열에서 마지막 열까지 도달하는 최대 개수를 알아내는 것.
        //파이프 여러개 설치 가능. 단, 겹치거나 접할수 없다. -> 해당 경로가 파이프일때, 별도의 방문처리 필요? (or 메서드리턴 boolean)
        //최대한 많이 설치하려면, 위쪽부터 탐색한다. 오른쪽 위, 오른쪽, 오른쪽 아래 순으로 탐색한다.

        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }

        System.out.println(pipeLineCnt);
    }

    static boolean dfs(int x, int y) {
        //원웅 집 도착
        if (y == C - 1) {
            pipeLineCnt++;
            return true;
        }

        //이동
        for (int i = 0; i < 3; i++) {
            int nextX = x + dX[i];
            int nextY = y + 1;

            if (isMovable(nextX, nextY) && !isVisited[nextX][nextY]) {
                isVisited[nextX][nextY] = true;
                //파이프라인 설치 시 방문처리 그대로 + dfs를 첫 depth로 빠져나온다.
                if (dfs(nextX, nextY)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C && (map[x][y] == '.');
    }
}
