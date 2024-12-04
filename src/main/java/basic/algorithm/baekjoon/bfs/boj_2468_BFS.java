package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2468_BFS {

    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] isVisited;
    static int maxCount, curCount;
    static int maxHeight;
    static int N;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isVisited = new boolean[N][N];
        q = new LinkedList<>();

        //init
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < N; k++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][k] = input;

                maxHeight = Math.max(input, maxHeight);
            }
        }

        //bfs
        for (int standard = 0; standard <= maxHeight; standard++) {
            curCount = 0;
            isVisited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {

                    if (map[i][k] > standard && !isVisited[i][k]) {
                        bfs(standard, new Point(i, k));

                        //현재 구역에 대한 탐색이 끝났기 때문에
                        curCount++;
                    }
                }
            }

            //현재 standard가 모든 지역보다 높기 때문에 더이상 수행해도 결과가 같다.
            if (curCount == 0) {
                System.out.println(maxCount);
                return;
            }

            maxCount = Math.max(curCount, maxCount);
        }

        //안전한 영역의 최대 개수
        //물에 잠기는 기준을 2~100까지 탐색. 단, 물에 잠기는 영역이 0일 경우 break;

        //bfs를 수행하면서 기준(standard)보다 큰 경우만 계속 탐색한다.
        //큐가 비었으면 curCount++;
    }

    static void bfs(int standard, Point point) {
        q.offer(point);
        isVisited[point.x][point.y] = true;

        while (!q.isEmpty()) {
            Point curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dX[i];
                int nextY = curPoint.y + dY[i];

                //이동 가능하며, 방문한적 없으며, 기준보다 높은 곳일 경우에만 탐색
                if (isMovable(nextX, nextY) && !isVisited[nextX][nextY] && map[nextX][nextY] > standard) {
                    bfs(standard, new Point(nextX, nextY));
                }
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
