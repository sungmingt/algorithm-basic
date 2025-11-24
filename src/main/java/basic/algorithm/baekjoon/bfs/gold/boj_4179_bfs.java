package basic.algorithm.baekjoon.bfs.gold;

import java.io.*;
import java.util.*;

public class boj_4179_bfs {

    static int R, C;
    static String[][] maze;
    static boolean[][] visited;
    static boolean[][] fireVisited;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> fires = new LinkedList<>();
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static Point jihoon;
    static int totalTimeSpent;
    static int fireTime = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new String[R][C];
        visited = new boolean[R][C];
        fireVisited = new boolean[R][C];

        //input maze
        for (int i = 0; i < R; i++) {
            String[] s = br.readLine().split("");

            for (int k = 0; k < C; k++) {
                maze[i][k] = s[k];

                if (maze[i][k].equals("J")) {
                    jihoon = new Point(i, k, 0);
                    visited[i][k] = true;
                } else if (maze[i][k].equals("F")) {
                    fires.offer(new Point(i, k, 0));
                    fireVisited[i][k] = true;
                }
            }
        }

        //불이 먼저 확산되고 지훈이가 이동하는데, 불이 난 곳에는 갈 수 없다.
        //불의 확산은, 각 bfs 루프마다, 즉 1분마다 실행시킨다.
        //이동할 곳이 없다면, 그냥 버린다.

        //move
        q.offer(jihoon);
        move();

        System.out.println(totalTimeSpent == 0 ? "IMPOSSIBLE" : totalTimeSpent);
    }

    private static void move() {
        while (!q.isEmpty()) {
            Point p = q.poll();

            //만일 지금 시간의 첫번째 이동이라면 -> 불 확산
            if (fireTime + 1 == p.time) {
                //불 확산
                spreadFire();
                fireTime++;
            }

            //가장자리에 도달했을 경우
            if (canEscape(p.x, p.y)) {
                totalTimeSpent = p.time + 1;
                break;
            }

            //이동
            for (int i = 0; i < 4; i++) {
                int nX = p.x + dX[i];
                int nY = p.y + dY[i];

                //이동할 수 있다면
                if (isMovable(nX, nY) && !visited[nX][nY] && !(maze[nX][nY].equals("#") || maze[nX][nY].equals("F"))) {
                    visited[nX][nY] = true;
                    q.offer(new Point(nX, nY, p.time + 1));
                }
            }
        }
    }

    private static void spreadFire() {
        if (fires.isEmpty()) return;

        for (int i = 0; i < fires.size(); i++) {
            Point p = fires.poll();

            for (int k = 0; k < 4; k++) {
                int nX = p.x + dX[k];
                int nY = p.y + dY[k];

                if (isMovable(nX, nY) && !fireVisited[nX][nY] && !maze[nX][nY].equals("#")) {
                    maze[nX][nY] = "F";
                    fireVisited[nX][nY] = true;
                    fires.offer(new Point(nX, nY, p.time + 1));
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    private static boolean canEscape(int x, int y) {
        return x == 0 || x == R - 1 || y == 0 || y == C - 1;
    }

    private static class Point {
        int x;
        int y;
        int time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
