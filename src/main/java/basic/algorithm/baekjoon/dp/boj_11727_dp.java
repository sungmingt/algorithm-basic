package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11727_dp {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        //dp[n] = dp[n-1] + (dp[n-2] x 2)
        //dp[1] = 1
        //dp[2] = 3
        //dp[3] = 5

        if (N == 1) {
            System.out.println(1);
            return;
        } else if (N == 2) {
            System.out.println(3);
            return;
        }

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
        }

        System.out.println(dp[N]);
    }
}
