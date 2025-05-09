package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940_bfs {

    static int N, M;
    static int[][] map, distances;
    static boolean[][] visited;
    static Queue<Point> q;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        distances = new int[N][M];
        q = new LinkedList<>();

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());

                //목표 지점 저장 (목표 지점에서부터 bfs 탐색)
                if (map[i][k] == 2) {
                    q.offer(new Point(i, k));
                    visited[i][k] = true;
                } else if (map[i][k] == 1) {  //도달하지 못할 경우 기본값은 -1이 되어야 한다.
                    distances[i][k] = -1;
                }
            }
        }

        //bfs
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dX[i];
                int nY = cur.y + dY[i];

                if (isMovable(nX, nY) && !visited[nX][nY] && map[nX][nY] == 1) {
                    visited[nX][nY] = true;
                    distances[nX][nY] = distances[cur.x][cur.y] + 1;
                    q.offer(new Point(nX, nY));
                }
            }
        }

        //print
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                sb.append(distances[i][k]).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
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
