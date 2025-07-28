package basic.algorithm.baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class boj_3190_dataStructure {

    static int N, K, L;
    static int[][] map;
    static boolean[][] applePoints;
    static boolean[][] isSnake;
    static Queue<Turn> turnQueue = new LinkedList<>();
    static Deque<Point> snake = new ArrayDeque<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isSnake = new boolean[N][N];
        applePoints = new boolean[N][N];

        //input apple
        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            applePoints[x][y] = true;
        }

        //input dir
        L = Integer.parseInt(br.readLine());
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            turnQueue.offer(new Turn(time, dir));
        }

        //머리를 늘려 다음칸에 위치.
        //벽이나 몸에 부딪히면
        //사과 : 사과 없어지고 꼬리 움직이지 않음 -> 길이 늘어남
        //사과x : 꼬리 이동 -> 길이 그대로

        //sudo
        //처음에는 오른쪽으로 이동. (dir=0)
        //방향 전환이 나올때까지 같은 방향으로 이동.
        //사과를 만나면 -> 사과 삭제. 꼬리 그대로.
        //사과를 만나지 않으면 -> 꼬리 이동

        //map 밖으로 나가거나, 현재 몸통에 부딫히면 break;
        //몸통 처리 어떻게 할것인가? -> deque

        int dir = 0;
        int time = 0;
        snake.offerFirst(new Point(0, 0));
        isSnake[0][0] = true;

        while (true) {
            if (!turnQueue.isEmpty()) {
                Turn nextTurn = turnQueue.peek();

                //방향 전환 해야한다면
                if (time == nextTurn.time) {
                    if (nextTurn.dir.equals("L")) {
                        dir = (dir + 3) % 4;
                    } else {
                        dir = (dir + 1) % 4;
                    }

                    turnQueue.poll();
                }
            }

            time++;

            //이동
            int nX = snake.peekLast().x + dx[dir];
            int nY = snake.peekLast().y + dy[dir];

            //몸통에 부딫히거나 map 밖이라면
            if (!isMovable(nX, nY) || isSnake[nX][nY]) {
                break;
            }

            //사과가 있다면
            if (applePoints[nX][nY]) {
                applePoints[nX][nY] = false;
            } else {
                Point tail = snake.pollFirst();
                isSnake[tail.x][tail.y] = false;
            }

            snake.offerLast(new Point(nX, nY));
            isSnake[nX][nY] = true;
        }

        System.out.println(time);

    }

    private static class Point {
        int x;
        int y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Turn {
        int time;
        String dir;

        Turn(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    private static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
