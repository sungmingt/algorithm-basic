package basic.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 단지번호붙이기_2667_DFS_BFS {  //다시 풀어보기

    static int[][] map;
    static boolean[][] visited;
    static int apartmentCount;
    static int[] apartmentSize;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String input = sc.next();

            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        apartmentSize = new int[N * N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 1 && !visited[i][j]) {
                    apartmentCount++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(apartmentSize);

        System.out.println(apartmentCount);
        for (int i = apartmentSize.length - apartmentCount; i < apartmentSize.length; i++) {
            System.out.println(apartmentSize[i]);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        apartmentSize[apartmentCount]++; //현재 단지의 아파트 개수 증가

        for (int i = 0; i < 4; i++) {
            int newX = x + dX[i];
            int newY = y + dY[i];

            if (0 <= newX && newX < map.length && 0 <= newY && newY < map.length) {
                if (map[newX][newY] == 1 && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }

        }
    }
}
