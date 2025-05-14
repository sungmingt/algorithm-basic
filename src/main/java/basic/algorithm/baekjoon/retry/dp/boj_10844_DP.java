package basic.algorithm.baekjoon.retry.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10844_DP {

    static int N;
    static long[][] dp;
    static int MOD = 1000000000;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        //dp[i][j] = i번째 자리의 수가 j일때 만들수 있는 숫자의 개수
        //dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]
        //  단, j=0일때와 j=9일때는 별도 처리 필요

        //첫번재 자리수는 1-9까지 1개씩 가능하다.
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 0; i <= 9; i++) {
            answer += dp(N, i);
        }

        System.out.println(answer % MOD);
    }

    static long dp(int idx, int val) {
        if (idx == 1) {
            return dp[1][val];
        }

        if (dp[idx][val] == 0) {
            if (val == 0) {
                dp[idx][val] = dp(idx - 1, val + 1);
            } else if (val == 9) {
                dp[idx][val] = dp(idx - 1, val - 1);
            } else {
                dp[idx][val] = dp(idx - 1, val - 1) + dp(idx - 1, val + 1);
            }
        }

        return dp[idx][val] % MOD;
    }
}
