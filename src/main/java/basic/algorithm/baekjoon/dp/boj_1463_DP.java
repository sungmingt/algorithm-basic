package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class boj_1463_DP {

    static Integer[] dp;

    public static void main(String[] args) {
        //2 또는 3으로 나누어 떨어지면 수행, 아니면 1 빼기
        //1을 만들어야 한다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[N + 1];

        System.out.println(dp(N));
    }

    static int dp(int num) {
        if(num == 1){
            return 0;
        }

        if (num <= 3) {
            return 1;
        }

        if (dp[num] == null) {
            if (num % 6 == 0) {
                dp[num] = Math.min(Math.min(dp(num / 3), dp(num / 2)), dp(num - 1)) + 1;
            } else if (num % 3 == 0) {
                dp[num] = Math.min(dp(num / 3), dp(num - 1)) + 1;
            } else if (num % 2 == 0) {
                dp[num] = Math.min(dp(num / 2), dp(num - 1)) + 1;
            } else {
                dp[num] = dp(num - 1) + 1;
            }
        }

        return dp[num];
    }
}
