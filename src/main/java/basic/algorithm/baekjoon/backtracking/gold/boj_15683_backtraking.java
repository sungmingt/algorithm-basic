package basic.algorithm.baekjoon.backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15683_backtraking {

    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int[] dir1 = {0, 1, 2, 3};
    static int[][] dirs2 = {{0, 1}, {2, 3}};
    static int[][] dirs3 = {{0, 2}, {0, 3}, {1, 2}, {1, 3}};
    static int[][] dirs4 = {
            {0, 1, 2}, // 상, 하, 좌
            {0, 1, 3}, // 상, 하, 우
            {0, 2, 3}, // 상, 좌, 우
            {1, 2, 3}  // 하, 좌, 우
    };

    static int N, M;
    static int[][] office;
    static List<Point> cctvList = new ArrayList<>();
    static int minBlindSpot = 65;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1일 경우 : x-, x+, y-, y+ 4가지 가능
        //  -> 반복문 순회하면 됨.
        //2일 경우 : x- x+, y- y+ 2가지 가능
        //  -> 01, 23
        //3일 경우 : x- y+, x+ y+, x+ y-, x- y- 4가지 가능
        //  -> 여기서는 dX1에서 경로 2개를 선택하면 됨. (02, 03, 12, 13)
        //4일 경우 : 각 경로 제외 (4가지 가능)
        //  -> 반복문 순회하면서 최소값을 구하고, 그 인덱스를 빼고 나머지를 탐색
        //5일 경우 : 모두 탐색

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < M; k++) {
                office[i][k] = Integer.parseInt(st.nextToken());

                //cctv일 경우
                if (1 <= office[i][k] && office[i][k] <= 5) {
                    cctvList.add(new Point(i, k));
                }
            }
        }

        //backtracking
        backtracking(0, office);
        System.out.println(minBlindSpot);
    }

    static void backtracking(int cctvIdx, int[][] office) {
        //모든 cctv를 탐색했다면
        if (cctvIdx == cctvList.size()) {
            int blindSpot = 0;

            //blindSpot 탐색
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < M; k++) {
                    if (office[i][k] == 0) {
                        blindSpot++;
                    }
                }
            }

            minBlindSpot = Math.min(minBlindSpot, blindSpot);
            return;
        }

        Point cctv = cctvList.get(cctvIdx);

        //cctv의 종류에 따라 각각 다르게 처리한다.
        if (office[cctv.x][cctv.y] == 1) {
            for (int i = 0; i < 4; i++) {
                int[][] tempOffice = copyOffice(office);
                surveillance(tempOffice, dir1[i], cctv.x, cctv.y);
                backtracking(cctvIdx + 1, tempOffice);
            }
        } else if (office[cctv.x][cctv.y] == 2) {
            for (int i = 0; i < 2; i++) {
                int[][] tempOffice = copyOffice(office);

                for (int k = 0; k < dirs2[i].length; k++) {
                    surveillance(tempOffice, dirs2[i][k], cctv.x, cctv.y);
                }

                backtracking(cctvIdx + 1, tempOffice);
            }
        } else if (office[cctv.x][cctv.y] == 3) {
            for (int i = 0; i < 4; i++) {
                int[][] tempOffice = copyOffice(office);

                for (int k = 0; k < dirs3[i].length; k++) {
                    surveillance(tempOffice, dirs3[i][k], cctv.x, cctv.y);
                }

                backtracking(cctvIdx + 1, tempOffice);
            }
        } else if (office[cctv.x][cctv.y] == 4) {
            for (int i = 0; i < 4; i++) {
                int[][] tempOffice = copyOffice(office);

                for (int k = 0; k < dirs4[i].length; k++) {
                    surveillance(tempOffice, dirs4[i][k], cctv.x, cctv.y);
                }

                backtracking(cctvIdx + 1, tempOffice);
            }
        } else if (office[cctv.x][cctv.y] == 5) {
            int[][] tempOffice = copyOffice(office);

            for (int i = 0; i < 4; i++) {
                surveillance(tempOffice, dir1[i], cctv.x, cctv.y);
            }

            backtracking(cctvIdx + 1, tempOffice);
        }
    }

    private static void surveillance(int[][] office, int dir, int cctvX, int cctvY) {
        int nx = cctvX;
        int ny = cctvY;

        //여기서 끝까지 탐색해야함
        while (true) {
            nx += dX[dir];
            ny += dY[dir];

            //탐색 (벽이거나 이동할수 없다면 탐색을 멈춘다)
            if (movable(nx, ny) && office[nx][ny] != 6) {
                if (office[nx][ny] == 0) {
                    office[nx][ny] = 7;
                }
            } else {
                break;
            }
        }
    }


    private static int[][] copyOffice(int[][] office) {
        int[][] tempOffice = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(office[i], 0, tempOffice[i], 0, M);
        }
        return tempOffice;
    }

    static boolean movable(int x, int y) {
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

