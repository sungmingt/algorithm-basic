package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class boj_1463_DP {

    static int dp[];
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //15 -> 5 -> 4 -> 2 -> 1
        //15 -> 14 -> 7 -> 6 -> 2 -> 1
        //6 -> 3 -> 1
        //6 -> 5 -> 4 -> 2 -> 1

        //3,2로 모두 나누어질경우 -> 세 경우의 수 중 최적값(최소 수행 값)을 구해야 한다.
        //3으로만 나누어질경우 -> 3으로 나누었을때와 1을 뺐을때 중 최적값을 구해야한다.
        //...

        dp = new int[N + 1];
        System.out.println(doDP(N));
    }

    static int doDP(int x) {
        if (x == 1) {
            return 0;
        }

        if (dp[x] == 0) {
            if (x % 6 == 0) {
                dp[x] = Math.min(Math.min(doDP(x / 3), doDP(x / 2)), doDP(x - 1)) + 1;
            } else if (x % 3 == 0) {
                dp[x] = Math.min(doDP(x / 3), doDP(x - 1)) + 1;
            } else if (x % 2 == 0) {
                dp[x] = Math.min(doDP(x / 2), doDP(x - 1)) + 1;
            } else {
                dp[x] = doDP(x - 1) + 1;
            }
        }

        return dp[x];
    }
}
