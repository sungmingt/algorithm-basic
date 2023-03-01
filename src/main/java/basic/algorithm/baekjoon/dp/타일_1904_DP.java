package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 타일_1904_DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N == 1) {
            System.out.println(1);
            return;
        }
        if(N == 2){
            System.out.println(2);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < N + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}
