package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1012_BFS {

    static int T, M, N, K;
    static int[][] map;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {1, -1, 0, 0};
    static int wormCount;
    static Queue<Point> q;
    static Queue<Point> cabbages;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            wormCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            cabbages = new LinkedList<>();
            q = new LinkedList<>();

            //input
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
                cabbages.offer(new Point(x, y));
            }

            //지렁이는 인접한곳 이동 후 끝이 아니라, 인접한곳에 배추가 있으면 계속 이동 가능
            //bfs
            while (!cabbages.isEmpty()) {
                Point cabbage = cabbages.poll();
                if (map[cabbage.x][cabbage.y] == 1) {
                    bfs(cabbage);
                    wormCount++;
                }
            }

            System.out.println(wormCount);
        }
    }

    static void bfs(Point point) {
        map[point.x][point.y] = 0;
        q.offer(point);

        while (!q.isEmpty()) {
            Point curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dX[i];
                int nextY = curPoint.y + dY[i];

                if (isMovable(nextX, nextY)) {
                    if (map[nextX][nextY] == 1) {
                        map[nextX][nextY] = 0;
                        q.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
