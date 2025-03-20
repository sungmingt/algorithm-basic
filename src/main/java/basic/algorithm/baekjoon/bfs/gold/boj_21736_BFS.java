package basic.algorithm.baekjoon.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_21736_BFS {

    static int N, M;
    static char[][] campus;
    static Queue<int[]> q;
    static int[] doyeon = new int[2];
    static int answer;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        q = new LinkedList<>();

        //input
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int p = 0; p < M; p++) {
                char c = input.charAt(p);
                campus[i][p] = c;

                if (c == 'I') {
                    doyeon[0] = i;
                    doyeon[1] = p;
                }
            }
        }

        //bfs
        bfs(doyeon);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    static void bfs(int[] doyeon) {
        q.offer(doyeon);
        campus[doyeon[0]][doyeon[1]] = 'X';

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dX[i];
                int nextY = cur[1] + dY[i];

                if (isMovable(nextX, nextY)) {
                    if (campus[nextX][nextY] == 'P') {
                        answer++;
                        q.offer(new int[]{nextX, nextY});
                        campus[nextX][nextY] = 'X';
                    } else if (campus[nextX][nextY] == 'O') {
                        q.offer(new int[]{nextX, nextY});
                        campus[nextX][nextY] = 'X';
                    }
                }
            }
        }
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
