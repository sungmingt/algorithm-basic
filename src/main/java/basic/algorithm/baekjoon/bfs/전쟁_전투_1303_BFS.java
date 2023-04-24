package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 전쟁_전투_1303_BFS {

    static String[] WandB = {"W", "B"};
    static String[][] graph;
    static boolean[][] visited;
    static int curN;
    static int curNsquare;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        //N명 뭉쳐있다(인접해있다) -> N*N의 위력
        //W : 아군, B : 적군
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new String[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = input.charAt(j) + "";
            }
        }

        //답
        StringBuilder sb = new StringBuilder();

        //아군과 적군 각각 따로 구한다. (BFS)
        //아군 구하기
        for (int t = 0; t < 2; t++) {
            String allyOrEnemy = WandB[t];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                    //아군이면서 방문안했다면
                    if (graph[i][j].equals(allyOrEnemy) && !visited[i][j]) {
                        visited[i][j] = true;
                        curN++;

                        Queue<Point> q = new LinkedList<>();
                        q.offer(new Point(j, i));

                        while (!q.isEmpty()) {
                            Point curPoint = q.poll();

                            for (int k = 0; k < 4; k++) {
                                int newX = curPoint.x + dX[k];
                                int newY = curPoint.y + dY[k];

                                //이동할 수 있다면
                                if (isMovable(newX, newY, N, M)) {

                                    //새로 이동한 곳이 방문 안했고 + 아군이라면
                                    if (!visited[newY][newX] && graph[newY][newX].equals(allyOrEnemy)) {
                                        visited[newY][newX] = true;
                                        q.offer(new Point(newX, newY));
                                        curN++;
                                    }
                                }
                            }
                        }
                    }

                    curNsquare += (curN * curN);
                    curN = 0;
                }
            }

            sb.append(curNsquare + " ");
            curNsquare = 0;
        }

        System.out.println(sb);
    }

    static boolean isMovable(int x, int y, int xLimit, int yLimit) {
        return 0 <= x && 0 <= y && x < xLimit && y < yLimit;
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
