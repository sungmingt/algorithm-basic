package basic.algorithm.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_1697_BFS {  //다시 풀어보기

    static int x;
    static int y;
    static int[] visited = new int[100001];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();

        q.add(x);
        visited[x] = 1; //0으로 방문여부 판별해야 하기 떄문에 1로 초기화. 마지막 연산값에서 -1 해줘야 한다.
        System.out.println(bfs(x));
    }

    static int bfs(int x) {
        while (!q.isEmpty()) {
            Integer current = q.poll();

            if (current == y) {
                return visited[y] - 1;
            }

            if (0 <= current - 1 && visited[current - 1] == 0) {
                q.add(current - 1);
                visited[current - 1] = visited[current] + 1;

            }
            if (current + 1 <= 100000 && visited[current + 1] == 0) {
                q.add(current + 1);
                visited[current + 1] = visited[current] + 1;

            }
            if (current * 2 <= 100000 && visited[current * 2] == 0) {
                q.add(current * 2);
                visited[current * 2] = visited[current] + 1;
            }
        }

        return 0;
    }
}
