package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 타일_1904_DP {

    static int[] dp;
    static int N;

    public static void main(String[] args) {
        //N:1 - 1 (1)
        //N:2 - 2 (00, 11)
        //N:3 - 3 (001, 111, 100)
        //N:4 - 5 (0011, 0000, 1001, 1100, 1111)
        //N:5 - 8 (00001, 11111, 00111, 10000, 00100, 11100, 10011, 11001)
        //-> 피보나치

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        if (N == 2) {
            System.out.println(2);
            return;
        }

        dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}
