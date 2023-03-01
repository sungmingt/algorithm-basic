package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 정수삼각형_1932_DP {

    static int[][] arr;
    static Integer[][] dp;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N][N];
        dp = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k <= i; k++) {
                arr[i][k] = sc.nextInt();
            }
        }

        //시작점 초기화
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }
        int answer = doDP(0, 0);

        System.out.println(answer);
    }

    static int doDP(int depth, int index) {
        if(depth == N - 1) return dp[N - 1][index];

        if (dp[depth][index] == null) {
            dp[depth][index] = Math.max(doDP(depth + 1, index), doDP(depth + 1, index + 1)) + arr[depth][index];
        }

        return dp[depth][index];
    }
}
