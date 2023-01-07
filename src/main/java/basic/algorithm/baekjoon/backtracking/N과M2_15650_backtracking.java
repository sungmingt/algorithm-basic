package basic.algorithm.baekjoon.backtracking;

import java.util.Scanner;

public class N과M2_15650_backtracking { //다시 풀어보기

    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    static int depth;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        arr = new int[M];

        dfs(depth);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;

                if (arr.length > 0 && depth > 0 && i < arr[depth - 1]) {
                } else {
                    arr[depth] = i;
                    dfs(depth + 1);
                }

                visited[i] = false;
            }
        }
    }
}
