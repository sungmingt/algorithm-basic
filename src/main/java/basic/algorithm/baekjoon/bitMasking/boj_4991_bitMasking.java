package basic.algorithm.baekjoon.bitMasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_4991_bitMasking {
    //bitMasking + BFS

    static int N, M;
    static char[][] room;
    static int[][][] visited;
    static Point robot;
    static int dirtyCnt;
    static List<Point> dirtyList;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            room = new char[N][M];
            dirtyList = new ArrayList<>();
            dirtyCnt = 0;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    room[i][j] = input.charAt(j);
                    if (room[i][j] == 'o') robot = new Point(i, j, 0);
                    if (room[i][j] == '*') {
                        dirtyList.add(new Point(i, j, 0));
                        dirtyCnt++;
                    }
                }
            }

            int result = bfs();
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs() {
        visited = new int[N][M][1 << dirtyCnt];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(robot.x, robot.y, 0));
        visited[robot.x][robot.y][0] = 1; // 1로 시작 (나중에 -1)

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.bit == (1 << dirtyCnt) - 1) {
                return visited[cur.x][cur.y][cur.bit] - 1; // 초기 1 보정
            }

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dX[i];
                int nY = cur.y + dY[i];
                int nextBit = cur.bit;

                if (!canMove(nX, nY) || room[nX][nY] == 'x') continue;

                // 더러운 칸일 경우 해당 index를 찾아 bit ON
                if (room[nX][nY] == '*') {
                    for (int d = 0; d < dirtyList.size(); d++) {
                        Point dirty = dirtyList.get(d);
                        if (dirty.x == nX && dirty.y == nY) {
                            nextBit = cur.bit | (1 << d);
                            break;
                        }
                    }
                }

                if (visited[nX][nY][nextBit] == 0) {
                    visited[nX][nY][nextBit] = visited[cur.x][cur.y][cur.bit] + 1;
                    q.offer(new Point(nX, nY, nextBit));
                }
            }
        }

        return -1;
    }

    static boolean canMove(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static class Point {
        int x, y, bit;

        Point(int x, int y, int bit) {
            this.x = x;
            this.y = y;
            this.bit = bit;
        }
    }
}
