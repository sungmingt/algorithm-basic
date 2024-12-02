package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178_BFS {

    static int[][] arr;
    static int[][] isVisited;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    static int N, M;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        //1 : 이동가능, 0 : 이동불가
        //지나야하는 최소 칸 수
        //시작/도착위치 포함!!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        isVisited = new int[N][M];
        q = new LinkedList<>();

        //input arr
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int k = 0; k < M; k++) {
                int input = s.charAt(k) - '0';
                arr[i][k] = input;
            }
        }

        q.offer(new Point(0, 0));
        isVisited[0][0] = 1;

        //110110
        //110110
        //111111
        //111101

        //12
        //23
        //345678
        //45

        //이전 visited의 값에서 +한 값을 저장해준다.

        while (!q.isEmpty()) {
            Point curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dX[i];
                int nextY = curPoint.y + dY[i];

                if (isMovable(nextX, nextY) && arr[nextX][nextY] == 1) {
                    //방문한적 없다면
                    if (isVisited[nextX][nextY] == 0) {
                        isVisited[nextX][nextY] = isVisited[curPoint.x][curPoint.y] + 1;
                        q.offer(new Point(nextX, nextY));
                    }
                }
            }
        }

        System.out.println(isVisited[N - 1][M - 1]);
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
