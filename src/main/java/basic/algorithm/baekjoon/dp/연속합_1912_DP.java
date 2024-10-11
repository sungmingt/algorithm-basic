package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 연속합_1912_DP {

    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //dp[0] = arr[0]이다.
        //dp[1] = 현재값(arr[i])과 (이전까지의 합 + 현재값) 중 더 큰값이다.
        //dp[i] = Math.max(arr[i], arr[i] + dp[i-1])

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new Integer[arr.length];
        dp[0] = arr[0];
        max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
