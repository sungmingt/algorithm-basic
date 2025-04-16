package basic.algorithm.baekjoon.backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5913_backtracking {

    static int count = 0;
    static int[][] map = new int[5][5];
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y - 1][x - 1] = -1;
        }

        if (map[0][0] == -1 || map[4][4] == -1) {
            System.out.println(0);
            return;
        }

        dfs(0, 0, 1);
        System.out.println(count);
    }

    static void dfs(int x, int y, int size) {
        if (x == 4 && y == 4) {
            if (size == 25 - K) {
                count++;
            }
            return;
        }

        map[y][x] = -1;

        if (y > 0 && map[y - 1][x] != -1) dfs(x, y - 1, size + 1);
        if (y < 4 && map[y + 1][x] != -1) dfs(x, y + 1, size + 1);
        if (x > 0 && map[y][x - 1] != -1) dfs(x - 1, y, size + 1);
        if (x < 4 && map[y][x + 1] != -1) dfs(x + 1, y, size + 1);

        map[y][x] = 0;
    }
}