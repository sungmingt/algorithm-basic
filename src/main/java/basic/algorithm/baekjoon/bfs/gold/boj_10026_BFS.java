package basic.algorithm.baekjoon.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026_BFS {

    static int N;
    static char[][] grid;
    static boolean[][] isVisited;
    static boolean[][] isVisitedBlind;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static Queue<Point> q;
    static int nonBlind;
    static int blind;

     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         grid = new char[N][N];
         isVisited = new boolean[N][N];
         isVisitedBlind = new boolean[N][N];

         //input
         for (int i = 0; i < N; i++) {
             String lane = br.readLine();

             for (int k = 0; k < N; k++) {
                 grid[i][k] = lane.charAt(k);
             }
         }

         //적록색약 : R,G를 동일시

         //search
         for (int i = 0; i < N; i++) {
             for (int k = 0; k < N; k++) {
                 //적록색약이 아닌 경우
                 if (!isVisited[i][k]) {
                     isVisited[i][k] = true;
                     nonBlind++;
                     bfs(new Point(i, k), grid[i][k], false);
                 }

                 //적록색약인 경우
                 if (!isVisitedBlind[i][k]) {
                     isVisitedBlind[i][k] = true;
                     blind++;
                     bfs(new Point(i, k), grid[i][k], true);
                 }
             }
         }

         System.out.println(nonBlind + " " + blind);
     }

    static void bfs(Point point, char colour, boolean isBlind) {
        q = new LinkedList<>();
        q.offer(point);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dX[i];
                int nextY = cur.y + dY[i];

                if (isBlind) {
                    searchAsBlind(colour, nextX, nextY);
                }else {
                    searchAsNonBlind(colour, nextX, nextY);
                }
            }
        }
    }

    private static void searchAsNonBlind(char colour, int nextX, int nextY) {
        if (isMovable(nextX, nextY) && !isVisited[nextX][nextY] && grid[nextX][nextY] == colour) {
            isVisited[nextX][nextY] = true;
            q.offer(new Point(nextX, nextY));
        }
    }

    private static void searchAsBlind(char colour, int nextX, int nextY) {
        if (isMovable(nextX, nextY) && !isVisitedBlind[nextX][nextY]){
            //인접한 색과 같거나, 현재 색과 인접한 색이 R 또는 G일 경우
            if ((grid[nextX][nextY] == colour)
                    || ((colour == 'R' || colour == 'G') && (grid[nextX][nextY] == 'R' || grid[nextX][nextY] == 'G'))) {
                isVisitedBlind[nextX][nextY] = true;
                q.offer(new Point(nextX, nextY));
            }
        }
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Point {
         int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
