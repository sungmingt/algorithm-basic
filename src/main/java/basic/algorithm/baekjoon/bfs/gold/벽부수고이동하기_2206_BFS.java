package basic.algorithm.baekjoon.bfs.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기_2206_BFS { //다시 풀어보기 (고려해야 할 게 정말 많다)
    static int N, M;
    static int[][] board;
    static boolean[][][] visited;
    static Queue<Node> q;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) {
        //N x M
        //1,1 에서 N,M으로 이동하는 최단경로
        //0 : 이동 가능, 1 : 이동 불가 (벽)

        //!!! 벽을 한 개까지 부술 수 있다 -> 이 조건을 못하겠음.
        //이동 불가능할때 부수는건 ok. 하지만 더 빨리 갈수있을때도 사용할 수 있다.

        //최단거리 출력 (시작, 도착 포함)
        //불가능하면 -1 출력

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];
        visited = new boolean[2][N][M];

        //board 입력
        for (int i = 0; i < board.length; i++) {
            String value = sc.next();
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = value.charAt(j) - '0';
            }
        }

        q = new LinkedList<>();
        q.offer(new Node(1, false, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            //도착지점이라면
            if ((curNode.x == M - 1) && (curNode.y == N - 1)) {
                System.out.println(curNode.distance);
                System.exit(0);
            }

            //새로운 지점으로 이동
            for (int i = 0; i < 4; i++) {
                int newX = curNode.x + dX[i];
                int newY = curNode.y + dY[i];

                //맵 내부라면
                if (!canMove(newX, newY)) {
                    continue;
                }

                //0이라면
                if (board[newY][newX] == 0) {
                    //방문하지 않았고, 이전에 벽을 부신적 없다면
                    if (!visited[0][newY][newX] && !curNode.crashed) {
                        visited[0][newY][newX] = true;
                        q.offer(new Node(curNode.distance + 1, false, newX, newY));
                    } //방문하지 않았고, 이전에 벽을 부신적 있다면
                    else if (!visited[1][newY][newX] && curNode.crashed) {
                        visited[1][newY][newX] = true;
                        q.offer(new Node(curNode.distance + 1, true, newX, newY));
                    }
                } else { //1이라면
                    if (!curNode.crashed) { //벽을 부신적 없다면 (방문 여부는 체크 안해도 된다. 어차피 1을 방문했으려면 부셨어야 하고, 그럼 crashUsed는 true이기 때문)
                        visited[1][newY][newX] = true;
                        q.offer(new Node(curNode.distance + 1, true, newX, newY));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean canMove(int newX, int newY) {
        return 0 <= newX && newX < M && 0 <= newY && newY < N;
    }

    static class Node{
        int distance;
        boolean crashed;
        int x;
        int y;

        public Node(int distance, boolean crashed, int x, int y) {
            this.distance = distance;
            this.crashed = crashed;
            this.x = x;
            this.y = y;
        }
    }
}

