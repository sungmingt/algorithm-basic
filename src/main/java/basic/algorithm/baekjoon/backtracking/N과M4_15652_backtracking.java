package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M4_15652_backtracking {
    static int N;
    static int M;
    static int depth;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        arr = new int[M];

        dfs(depth);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (depth > 0 && i < arr[depth - 1]) { //내림차순이라면
            } else {
                arr[depth] = i;
                dfs(depth + 1);
            }
        }
    }
}
