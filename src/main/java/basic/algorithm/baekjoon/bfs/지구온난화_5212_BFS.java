package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 지구온난화_5212_BFS {

    static int R;
    static int C;
    static String[][] map;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static String[][] after;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = new LinkedList<>();
        R = Integer.parseInt(st.nextToken()); //세로길이
        C = Integer.parseInt(st.nextToken()); //가로길이

        map = new String[R][C];
        after = new String[R][C];

        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                String val = split[j];
                if(val.equals("X")) q.offer(new Point(i, j));
                map[i][j] = val;
            }
        }

        int maxNewR = R - 1;
        int maxNewC = C - 1;
        int minNewR = 0;
        int minNewC = 0;

        //바다로 모두 채운후, 생존하는 육지인 경우에만 X로 바꿔준다.
        for (int i = 0; i < after.length; i++) {
            Arrays.fill(after[i], ".");
        }

        //bfs
        while (!q.isEmpty()) {
            Point poll = q.poll();
            int oceanCount = 0;

            for (int i = 0; i < 4; i++) {
                int newX = poll.x + dX[i];
                int newY = poll.y + dY[i];

                //바다인 경우
                if (!canMove(newX, newY) || map[newX][newY].equals(".")) {
                    oceanCount++;
                }
            }

            //생존한 육지인 경우
            if (oceanCount < 3) {
                maxNewR = Math.max(poll.x, maxNewR);
                maxNewC = Math.max(poll.y, maxNewC);
                minNewR = Math.min(poll.x, minNewR);
                minNewC = Math.min(poll.y, minNewC);
                after[poll.x][poll.y] = "X";
            }
        }

        //지도의 가로 최대값, 세로 최대값을 구해 해당 범위만큼만 출력한다.
        StringBuilder sb = new StringBuilder();
        for (int i = minNewR; i <= maxNewR; i++) {
            for (int j = minNewC; j <= maxNewC; j++) {
                sb.append(after[i][j]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean canMove(int newX, int newY) {
        return 0 <= newX && newX < R && 0 <= newY && newY < C;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
