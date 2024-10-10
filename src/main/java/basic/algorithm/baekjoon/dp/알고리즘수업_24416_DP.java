package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 알고리즘수업_24416_DP {

    static int[] dp;
    static int fibCount;
    static int dpCount;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        fib(N);
        dp(N);

        System.out.print(fibCount + " " + dpCount);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            fibCount++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    static int dp(int n) {
        for (int i = 3; i < n + 1; i++) {
            dpCount++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
