package basic.algorithm.baekjoon.bfs.gold;

import java.io.*;
import java.util.*;

public class boj_14503_bfs {

    static int N, M;
    static int cleanCnt;
    static int[][] map;
    static int dir; //0,1,2,3 ->  북,동,남,서
    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N,M input
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //pos/dir input
        st = new StringTokenizer(br.readLine());
        int initX = Integer.parseInt(st.nextToken());
        int initY = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        //map input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        //방향
        //반시계방향 회전 -> idx--;
        //ex) dir = 0 -> 북쪽방향 -> dX[0],dY[0] 로 이동

        //후진
        // 0 or 1 : +2
        // 2 or 3 : -2

        //청소X=0, 청소O=2, 벽=1

        //bfs
        //벽이거나, 방문했다면 X

        Point cur = new Point(initX, initY);
        doClean(cur);

        System.out.println(cleanCnt);
    }

    private static int doClean(Point cur) {
        while (true) {
            //현재 칸이 청소되지 않았다면
            if (map[cur.x][cur.y] == 0) {
                map[cur.x][cur.y] = 2;
                cleanCnt++;
            }

            boolean isExists = false;

            //주변 4칸 탐색
            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dX[i];
                int nY = cur.y + dY[i];

                if (canMove(nX, nY) && map[nX][nY] == 0) {
                    isExists = true;
                    break;
                }
            }

            //청소할 곳이 없다면
            if (!isExists) {
                int tempDir = dir;

                //후진하기
                if (tempDir == 0 || tempDir == 1) tempDir += 2;
                else tempDir -= 2;

                int nX = cur.x + dX[tempDir];
                int nY = cur.y + dY[tempDir];

                //후진할수 있다면 후진
                if (canMove(nX, nY) && map[nX][nY] != 1) {
                    cur = new Point(nX, nY);
                } else {
                    //벽이라서 후진 불가능하다면 stop;
                    break;
                }

            } else {
                //청소할 곳이 있다면

                //반시계방향 회전
                dir = dir == 0 ? 3 : dir - 1;

                int nX = cur.x + dX[dir];
                int nY = cur.y + dY[dir];

                if (canMove(nX, nY) && map[nX][nY] == 0) {
                    cur = new Point(cur.x + dX[dir], cur.y + dY[dir]);
                }
            }
        }

        return cleanCnt;
    }


    private static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
