package basic.algorithm.baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178_BFS {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int targetX;
    static int targetY;
    static int[][] maze;
    static int[][] distance;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        targetX = sc.nextInt();
        targetY = sc.nextInt();

        maze = new int[targetX][targetY];
        visited = new boolean[targetX][targetY];
        distance = new int[targetX][targetY];

        //미로 입력
        for (int i = 0; i < targetX; i++) {
            String input = sc.next();

            for (int j = 0; j < targetY; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(distance[targetX - 1][targetY - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<Pair> q = new ArrayDeque<>();

        //1. 1이면서 and 방문하지 않았을 때만 이동한다.
        //2. 인덱스 바깥으로 나가지 않을 경우에만 이동한다.
        // 이동 시 해당 배열 값은 이동 거리가 된다.
        visited[x][y] = true;
        distance[x][y] = 1;
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair currentPair = q.poll();

            for (int i = 0; i < 4; i++) {
                int currentX = currentPair.x + dx[i];
                int currentY = currentPair.y + dy[i];

                if (currentX >= 0 && currentY >= 0 && currentX < targetX && currentY < targetY) {
                    if (maze[currentX][currentY] == 1 && !visited[currentX][currentY]) {

                        distance[currentX][currentY] = distance[currentPair.x][currentPair.y] + 1;
                        visited[currentX][currentY] = true;
                        q.offer(new Pair(currentX, currentY));
                    }
                }
            }
        }
    }
}

class Pair{
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}