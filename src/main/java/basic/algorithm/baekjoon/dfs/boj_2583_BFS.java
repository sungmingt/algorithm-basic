package basic.algorithm.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2583_BFS {

    static int M, N, K;
    static boolean[][] paper;
    static StringTokenizer st;
    static Queue<Point> q;
    static int curEmptySpace;
    static List<Integer> emptySpaces = new ArrayList<>();
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        paper = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int fromY = Integer.parseInt(st.nextToken());
            int fromX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            for (int k = fromX; k < endX; k++) { //0 2
                for (int p = fromY; p < endY; p++) { //4 6
                    paper[k][p] = true;
                }
            }
        }

        //직사각형의 좌표를 입력받을때마다 방문처리해준다.
        //어차피 paper[0][0]의 값은 의미없는 값이다. -> 편의를 위해 입력값 1,1 -> 0,0 으로 계산한다.
        //예를 들어, 0,0 - 2,2가 직사각형이라면, paper[0][0] ~ paper[1][1] 방문 처리해준다.

        //BFS를 통해 빈공간이 시작될때마다 emptySpaceCount++
        //queue를 이용한다.

        q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int k = 0; k < N; k++) {
                if(paper[i][k]) continue;
                bfs(new Point(i, k));

                emptySpaces.add(curEmptySpace);
                curEmptySpace = 0;
            }
        }

        System.out.println(emptySpaces.size());

        Collections.sort(emptySpaces);
        for (int spaceSize : emptySpaces) {
            System.out.print(spaceSize + " ");
        }
    }

    static void bfs(Point point) {
        q.offer(point);
        paper[point.x][point.y] = true;

        while (!q.isEmpty()) {
            curEmptySpace++;
            Point curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dX[i];
                int nextY = curPoint.y + dY[i];

                //빈 공간이라면
                if (isMovable(nextX, nextY) && !paper[nextX][nextY]) {
                    q.offer(new Point(nextX, nextY));
                    paper[nextX][nextY] = true;
                }
            }
        }
    }

    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}
