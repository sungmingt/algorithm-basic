package basic.algorithm.baekjoon.bruteForce.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2615_bruteForce {

    static int[][] board = new int[19][19];
    static int dX[] = {0, 1, 1, 1}; //우 하 좌하 우하
    static int dY[] = {1, 0, -1, 1}; //우 하 좌하 우하
    static Queue<Point> q = new LinkedList();
    static StringBuilder sb = new StringBuilder();
    static boolean[][][] visited = new boolean[19][19][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //input
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < 19; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());

                if (board[i][k] == 1 || board[i][k] == 2) {
                    q.offer(new Point(i, k));
                }
            }
        }

        //검은 바둑알은 1, 흰 바둑알은 2

        // 검은색이 이겼을 경우에는 1을, 흰색이 이겼을 경우에는 2를, 아직 승부가 결정되지 않았을 경우에는 0을 출력
        //가장 왼쪽, 세로로 놓인 경우 가장 위의 위치 출력

        //흰 알과 검은 알을 큐에 담는다.
        //흰 알과 검은 알을 각각 순회하며 dfs 탐색
        //이때, 좌표와 방향이 담긴 visited[][][] 배열을 통해 8가지 모두 탐색할 필요 없이 4가지만 탐색하면 된다.
        //  -> 큐에 담을때 좌표 순으로 담았고, 만일 해당 좌표가 해당 방향으로 탐색된적 있다면, 더이상 그 방향으로는 오목이 완성되지 않는다는 뜻이다.
        //  -> 그리고, 이렇게 하면 오목을 완성했을때 반대 방향도 탐색하지 않아도 된다. (좌표순으로 4방향을 탐색하기 때문에, 반대 방향으로의 탐색은 이미 끝난 것이기 때문)

        //순서대로 탐색한다고 하면, 우, 하, 좌하, 우하만 탐색하면 된다.
        //만일 다음 탐색 값이 현재 값과 같고, 해당 방향으로 방문하지 않았고, 움직일수 있다면 depth++ 후 계속 탐색
        //depth == 5 일 경우, 6목이 아닌걸 검증하고 정답 출력


        //search
        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++) {
                dfs(poll, i, 1, poll);
            }
        }

        System.out.println(sb.length() == 0 ? 0 : sb);
    }

    private static void dfs(Point cur, int dir, int depth, Point first) {
        if (depth == 5) {
            if (proveNotAnymore(cur, dir)) {
                sb.append(board[cur.x][cur.y]);
                sb.append("\n");

                if (dir == 2) { //좌하 방향일때만 마지막 요소를 출력
                    sb.append(cur.x + 1).append(" ").append(cur.y + 1);
                } else {
                    sb.append(first.x + 1).append(" ").append(first.y + 1);
                }

                return;
            }
        }

        //현재 지점에 현재 방향으로 탐색
        int nX = cur.x + dX[dir];
        int nY = cur.y + dY[dir];
        Point nPoint = new Point(nX, nY);

        //판 내부 + 같은 돌 + 같은 방향 방문 x
        if (isMovable(nX, nY) && board[nX][nY] == board[cur.x][cur.y] && !visited[nX][nY][dir]) {
            visited[nX][nY][dir] = true;
            dfs(nPoint, dir, depth + 1, first);
        }
    }

    private static boolean proveNotAnymore(Point cur, int dir) {
        int nX = cur.x + dX[dir];
        int nY = cur.y + dY[dir];

        //판의 마지막이거나 같은 색이라면 true
        if (isMovable(nX, nY) && board[nX][nY] == board[cur.x][cur.y]) {
            return false;
        }

        return true;
    }

    private static boolean isMovable(int x, int y) {
        return 0 <= x && x < 19 && 0 <= y && y < 19;
    }

    private static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
