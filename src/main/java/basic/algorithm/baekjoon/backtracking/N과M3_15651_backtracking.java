package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M3_15651_backtracking {

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
    //depth : 1, arr : {1}
    //2, {1, 1}
    //return
    //1, {1, 1}
    //2, {1, 2}
    static void dfs(int depth) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }

    }
}
