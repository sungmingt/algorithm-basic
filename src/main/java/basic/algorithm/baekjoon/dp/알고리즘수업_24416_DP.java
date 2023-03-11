package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 알고리즘수업_24416_DP {

    static int[] dp;
    static int N;
    static int idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        recursive(N);
        System.out.print(idx + " ");
        idx = 0;

        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        dp(N);
        System.out.print(idx);
    }

    static int recursive(int num) {
        if (num <= 2) {
            idx++;
            return 1;
        }

        return recursive(num - 1) + recursive(num - 2);
    }

    static void dp(int num) {

        for (int i = 3; i <= num; i++) {
            idx++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
}
