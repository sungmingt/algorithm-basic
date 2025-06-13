package basic.algorithm.baekjoon.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2636_bfs {

    static int N, M;
    static int[][] map;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0; //소요 시간
        int cheeseCnt = 0; //마지막 순간의 치즈 개수

        //각 루프마다(1시간마다) 외부 공기를 갱신하고 + 외부 공기와 맞닿은 치즈를 녹인다.
        while (true) {
            boolean[][] visited = new boolean[N][M];
            markOutsideAir(visited);

            List<Point> toMelt = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && isTouchingOutsideAir(i, j, visited)) {
                        toMelt.add(new Point(i, j));
                    }
                }
            }

            if (toMelt.isEmpty()) break;

            cheeseCnt = toMelt.size();
            for (Point p : toMelt) {
                map[p.x][p.y] = 0;
            }

            time++;
        }

        System.out.println(time);
        System.out.println(cheeseCnt);
    }

    static void markOutsideAir(boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dX[d];
                int ny = cur.y + dY[d];

                if (!isMovable(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }

    static boolean isTouchingOutsideAir(int x, int y, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dX[i];
            int ny = y + dY[i];
            if (isMovable(nx, ny) && visited[nx][ny]) return true;
        }

        return false;
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

