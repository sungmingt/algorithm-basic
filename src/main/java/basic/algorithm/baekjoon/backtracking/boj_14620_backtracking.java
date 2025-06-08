package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14620_backtracking {

    static int N;
    static int[][] flowerbed;
    static int minCost = Integer.MAX_VALUE;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flowerbed = new int[N][N];

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < N; k++) {
                flowerbed[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        //두 꽃잎이 닿거나, 화단 밖으로 나가면 꽃이 모두 죽게 된다.

        //씨앗 위치를 기준으로 brute force
        //씨앗으르 심을 수 있는 위치 : (1,1) ~ (N-2,N-2)
        //다음 씨앗을 심을 수 있는 위치 : 이전 씨앗과 겹치지 않는 곳

        boolean[][] visited = new boolean[N][N];

        for (int i = 1; i < N - 1; i++) {
            for (int k = 1; k < N - 1; k++) {
                backtracking(visited, 0, 0);
            }
        }

        System.out.println(minCost);
    }

    private static void backtracking(boolean[][] visited, int seedCnt, int totalCost) {
        if (seedCnt == 3) {
            minCost = Math.min(minCost, totalCost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (canPlant(i, j, visited)) {
                    int cost = plantOrRemove(i, j, visited, true);
                    backtracking(visited, seedCnt + 1, totalCost + cost);
                    plantOrRemove(i, j, visited, false);
                }
            }
        }

    }

    //해당 구역의 상하좌우가 모두 비어있는지 탐색.
    static boolean canPlant(int x, int y, boolean[][] visited) {
        for (int d = 0; d < 5; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!(0 <= nx && nx < N && 0 <= ny && ny < N) || visited[nx][ny]) return false;
        }

        return true;
    }

    //심거나 or 심어진 씨앗을 지우거나 (상태 복원)
    static int plantOrRemove(int x, int y, boolean[][] visited, boolean isPlanting) {
        int cost = 0;

        for (int d = 0; d < 5; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            visited[nx][ny] = isPlanting;
            cost += flowerbed[nx][ny];
        }

        return cost;
    }
}
