package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2156_DP {

    static int[] dp;
    static int[] glasses;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        glasses = new int[N];

        for (int i = 0; i < N; i++) {
            glasses[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(glasses[0]);
            return;
        } else if (N == 2) {
            System.out.println(glasses[0] + glasses[1]);
            return;
        }

        dp[0] = glasses[0];
        dp[1] = glasses[0] + glasses[1];
        dp[2] = Math.max(Math.max(glasses[0] + glasses[2], glasses[1] + glasses[2]), dp[1]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + glasses[i - 1]) + glasses[i], dp[i - 1]);
        }

        System.out.println(dp[N - 1]);
    }
}