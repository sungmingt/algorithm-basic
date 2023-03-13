package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 연속합_1912_DP {

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        //10 -4 3  1  5  6 -35 12 21 -1
        //10  6 9 10 15 21 -14 12 33 32

        //dp[0] = arr[0]이다.
        //dp[1] = 현재값(arr[i])과 (이전까지의 합 + 현재값) 중 더 큰값이다.
        //dp[i] = Math.max(arr[i], arr[i] + dp[i-1])

        dp = new Integer[N];
        dp[0] = arr[0];

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);

            if (max < dp[i]) max = dp[i];
        }
    }
}
