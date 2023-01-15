package basic.algorithm.baekjoon.bfs.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_7576_BFS { //풀이 한번 찾아보기

    static int[][] box;
    static int[][] visited;
    static int doneCount;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static Queue<Point> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        box = new int[N][M];
        visited = new int[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                int input = sc.nextInt();
                if (input == 1) {
                    doneCount++;
                    q.add(new Point(i, j));
                    visited[i][j] = 1; //마지막에 -1
                } else if(input == -1) {
                    doneCount++;
                }

                box[i][j] = input;
            }
        }
        //1 : 익은 토마토,  0 : 익지 않은 토마토,  -1 : 토마토 없음
        //토마토가 모두 익을때까지 걸리는 최소 일수 출력
        //모두 익지 못하는 상황이면 -1 출력
        //익을때마다 doneCount 추가 -> 메서드 끝나고 doneCount가 N*M이 아니면 -1 출력

        if(doneCount == N * M) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            Point current = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dX[i];
                int newY = current.y + dY[i];

                if (0 <= newX && newX < N && 0 <= newY && newY < M) {
                    if (visited[newX][newY] == 0 && box[newX][newY] == 0) {
                        visited[newX][newY] = visited[current.x][current.y] + 1;
                        q.offer(new Point(newX, newY));
                        doneCount++;

                        if (doneCount == N * M) {
                            System.out.println(visited[newX][newY] - 1);
                            return;
                        }
                    }
                }
            }
        }
        //다 익을 수 없다면
        System.out.println(-1);
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
