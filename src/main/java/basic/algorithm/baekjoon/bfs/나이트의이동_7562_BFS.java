package basic.algorithm.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동_7562_BFS {

    static int[][] board;
    static int[][] visited;
    static Queue<Index> q;
    static int[][] moveCases = { //이동할 수 있는 경우의 수
            {-2, -1}, {-2, +1},
            {-1, -2}, {-1, 2},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
    };
    static int targetX;
    static int targetY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int length = sc.nextInt();
            board = new int[length][length];
            visited = new int[length][length];

            int curX = sc.nextInt();
            int curY = sc.nextInt();

            targetX = sc.nextInt();
            targetY = sc.nextInt();

            System.out.println(bfs(curX, curY));
        }
    }

    static int bfs(int x, int y) {
        q = new LinkedList<>();
        visited[x][y] = 1; //1부터 시작 -> 마지막에 -1 해줘야 한다.
        q.offer(new Index(x, y));

        while (!q.isEmpty()) {
            Index current = q.poll();

            if (current.x == targetX && current.y == targetY) {
                return visited[current.x][current.y] - 1;
            }

            for (int i = 0; i < moveCases.length; i++) {
                int newX = current.x + moveCases[i][0];
                int newY = current.y + moveCases[i][1];

                if (0 <= newX && newX < board.length && 0 <= newY && newY < board.length) {
                    if (visited[newX][newY] == 0) {
                        visited[newX][newY] = visited[current.x][current.y] + 1;
                        q.offer(new Index(newX, newY));
                    }
                }
            }
        }

        return -1;
    }
}
class Index{
    int x;
    int y;

    Index(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
