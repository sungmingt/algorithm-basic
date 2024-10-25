package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 지구온난화_5212_BFS {

    static String[][] curMap;
    static String[][] newMap;
    static int R, C;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static StringTokenizer st;
    static int minR, minC;
    static int maxR, maxC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        curMap = new String[R][C];
        newMap = new String[R][C];
        minR = R - 1;
        minC = C - 1;

        for (int i = 0; i < R; i++) {
            String[] s = br.readLine().split("");

            for (int k = 0; k < C; k++) {
                curMap[i][k] = s[k];
            }
        }

        for (int i = 0; i < newMap.length; i++) {
            Arrays.fill(newMap[i], ".");
        }

        //지도(curMap) 탐색
        for (int i = 0; i < curMap.length; i++) {
            for (int k = 0; k < curMap[i].length; k++) {
                if(curMap[i][k].equals(".")) continue;

                //섬일 경우, 주변 탐색 시작
                search(i, k);
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for (int k = minC; k <= maxC; k++) {
                System.out.print(newMap[i][k]);
            }
            System.out.println();
        }
    }

    static void search(int x, int y) {
        int seaCount = 0;

        for (int i = 0; i < 4; i++) {
            int newX = x + dX[i];
            int newY = y + dY[i];

            if (isMovable(newX, newY)) {
                if (curMap[newX][newY].equals(".")) {
                    seaCount++;
                }
            } else {
                seaCount++;
            }
        }

        //3면 이상이 바다라면 -> 바다
        if (seaCount < 3) {
            minR = Math.min(minR, x);
            minC = Math.min(minC, y);
            maxR = Math.max(maxR, x);
            maxC = Math.max(maxC, y);
            newMap[x][y] = "X";
        }
    }

    static boolean isMovable(int x, int y) {
        return (0 <= x  && x < R) && (0 <= y && y < C);
    }



//    static int R;
//    static int C;
//    static String[][] map;
//    static int[] dX = {-1, 1, 0, 0};
//    static int[] dY = {0, 0, -1, 1};
//    static String[][] after;
//    static Queue<Point> q;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        q = new LinkedList<>();
//        R = Integer.parseInt(st.nextToken()); //세로길이
//        C = Integer.parseInt(st.nextToken()); //가로길이
//
//        map = new String[R][C];
//        after = new String[R][C];
//
//        for (int i = 0; i < R; i++) {
//            String[] split = br.readLine().split("");
//
//            for (int j = 0; j < C; j++) {
//                String val = split[j];
//                if(val.equals("X")) q.offer(new Point(i, j));
//                map[i][j] = val;
//            }
//        }
//
//        int maxNewR = R - 1;
//        int maxNewC = C - 1;
//        int minNewR = 0;
//        int minNewC = 0;
//
//        //바다로 모두 채운후, 생존하는 육지인 경우에만 X로 바꿔준다.
//        for (int i = 0; i < after.length; i++) {
//            Arrays.fill(after[i], ".");
//        }
//
//        //bfs
//        while (!q.isEmpty()) {
//            Point poll = q.poll();
//            int oceanCount = 0;
//
//            for (int i = 0; i < 4; i++) {
//                int newX = poll.x + dX[i];
//                int newY = poll.y + dY[i];
//
//                //바다인 경우
//                if (!canMove(newX, newY) || map[newX][newY].equals(".")) {
//                    oceanCount++;
//                }
//            }
//
//            //생존한 육지인 경우
//            if (oceanCount < 3) {
//                maxNewR = Math.max(poll.x, maxNewR);
//                maxNewC = Math.max(poll.y, maxNewC);
//                minNewR = Math.min(poll.x, minNewR);
//                minNewC = Math.min(poll.y, minNewC);
//                after[poll.x][poll.y] = "X";
//            }
//        }
//
//        //지도의 가로 최대값, 세로 최대값을 구해 해당 범위만큼만 출력한다.
//        StringBuilder sb = new StringBuilder();
//        for (int i = minNewR; i <= maxNewR; i++) {
//            for (int j = minNewC; j <= maxNewC; j++) {
//                sb.append(after[i][j]);
//            }
//
//            sb.append("\n");
//        }
//
//        System.out.println(sb);
//    }
//
//    static boolean canMove(int newX, int newY) {
//        return 0 <= newX && newX < R && 0 <= newY && newY < C;
//    }
//
//    static class Point{
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}
