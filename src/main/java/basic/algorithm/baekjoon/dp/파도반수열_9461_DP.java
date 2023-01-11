package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 파도반수열_9461_DP{

    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 0; i < N; i++) {
            //P(11) = P(10) + P(6)
            //P(10) = P(9) + P(5)
            //P(9) = P(8) + P(4)
            //P(N) = P(N-1) + P(N - 5)  ->  N > 5 일 경우에만 성립가능

            int input = sc.nextInt();
            System.out.println(P(input));
        }
    }

    static long P(int n) {
        if (dp[n] != 0 || n <= 5) {  //이미 구했던 값일 경우
            return dp[n];
        }

        dp[n-1] = P(n - 1);
        dp[n-5] = P(n - 5);

        return dp[n - 1] + dp[n - 5];
    }
}
