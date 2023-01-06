package basic.algorithm.baekjoon.bfs;

import java.util.Scanner;

public class 유기농배추_1012_DFS_BFS { //BFS로 구현

    static int[][] map;
    static boolean[][] visited;
    static int wormCount;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {1, -1, 0, 0};
    static int xLength;
    static int yLength;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();

        //각 테스트케이스
        for (int i = 0; i < testCaseCount; i++) {
            xLength = sc.nextInt();
            yLength = sc.nextInt();
            int cabbageCount = sc.nextInt();

            map = new int[xLength][yLength];
            visited = new boolean[xLength][yLength];
            wormCount = 0;

            //배추 위치 입력받기
            for (int j = 0; j < cabbageCount; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[x][y] = 1;
            }

            for (int k = 0; k < map.length; k++) {
                for (int p = 0; p < map[k].length; p++) {

                    if (map[k][p] == 1 && !visited[k][p]) { //배추가 심어져있고, 방문하지 않았다면
                        wormCount++;
                        dfs(k, p);
                    }
                }
            }

            System.out.println(wormCount);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dX[i];
            int newY = y + dY[i];

            if (0 <= newX && newX < xLength && 0 <= newY && newY < yLength) {
                if (map[newX][newY] == 1 && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }
}
