package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열_9461_DP{

    static long[] dp = new long[101];
    static int N;

    public static void main(String[] args) throws IOException {
        //P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
        //규칙 : N=4일때부터 P(N) == P(N-2) + P(N-3)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            System.out.println(doDP(N));
        }
    }

    static long doDP(int N) {
        if (dp[N] == 0) {
            dp[N] = doDP(N - 2) + doDP(N - 3);
        }

        return dp[N];
    }
}
