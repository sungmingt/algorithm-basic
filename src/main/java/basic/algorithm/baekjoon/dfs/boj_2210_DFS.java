package basic.algorithm.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_2210_DFS {

    static int[][] board = new int[5][5];
    static Set<String> num = new HashSet<>();
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //input
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < 5; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        //서로 다른 6자리 수의 개수, 6자리 수를 어떻게 관리할것인가?
        //-> HashSet<Integer>

        //한번 거쳤던 칸을 다시 거쳐도 된다.
        //  -> visited 처리 x, 6자리를 만들면 return;

        //dfs
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                dfs(i, k, board[i][k] + "");
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, String curNum) {
        if (curNum.length() == 6) {
            if (!num.contains(curNum)) {
                num.add(curNum);
                answer++;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dX[i];
            int nextY = y + dY[i];

            if (isMovable(nextX, nextY)) {
                dfs(nextX, nextY, curNum + board[nextX][nextY]);
            }
        }
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }
}
