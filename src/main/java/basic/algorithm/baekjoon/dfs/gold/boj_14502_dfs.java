package basic.algorithm.baekjoon.dfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502_dfs {

    static int N, M;
    static int[][] map;
    static Queue<Point> virusPoints;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int maxSafeArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virusPoints = new LinkedList<>();

        //0은 빈 칸, 1은 벽, 2는 바이러스
        //상하좌우 바이러스 확산
        //벽 3개 세워서 안전영역의 최대값 구하기

        //안전영역을 만드려면 벽으로 공간을 가둬야한다.

        //먼저, 바이러스가 있는곳을 알아야한다. -> 바이러스 좌표를 저장
        //3개의 벽을 dfs를 통해 세우고, 각 경우마다 bfs를 통해 바이러스를 모두 퍼트리면서 안전영역의 최대값을 구한다.

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < M; k++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][k] = input;

                //바이러스일 경우 큐에 추가
                if (input == 2) {
                    virusPoints.offer(new Point(i, k));
                }
            }
        }

        setWalls(0);
        System.out.println(maxSafeArea);
    }

    static void setWalls(int wallCnt) {
        //벽을 3개 모두 세우면 -> 바이러스 전파
        if (wallCnt == 3) {
            spreadViruses();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                //빈칸일 경우에만 벽을 세울 수 있다.
                if (map[i][k] == 0) {
                    map[i][k] = 1;
                    setWalls(wallCnt + 1);
                    map[i][k] = 0;
                }
            }
        }
    }

    static void spreadViruses() {
        //원본 연구소를 깊은 복사
        int[][] copyOfMap = new int[N][M];
        for (int i = 0; i < N; i++) copyOfMap[i] = map[i].clone();

        Queue<Point> q = new LinkedList<>();
        for (Point v : virusPoints) {
            q.offer(v);
        }

        //bfs
        while (!q.isEmpty()) {
            Point curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dX[i];
                int nextY = curPoint.y + dY[i];

                //바이러스가 전파된다면
                if (isSpreading(nextX, nextY, copyOfMap)) {
                    q.offer(new Point(nextX, nextY));
                    copyOfMap[nextX][nextY] = 2; //바이러스로 변환
                }
            }
        }

        //바이러스 전파가 끝났을때, 빈칸(0)의 개수의 최대값
        int curSafeArea = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (copyOfMap[i][k] == 0) {
                    curSafeArea++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, curSafeArea);
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static boolean isSpreading(int x, int y, int[][] copyMap) {
        return isMovable(x, y) && copyMap[x][y] == 0;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
