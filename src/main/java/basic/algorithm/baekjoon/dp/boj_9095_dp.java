package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095_dp {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        //1 : 1 -> 1개
        //2 -> 1+1, 2 -> 2개
        //3 -> 1+1+1, 1+2, 2+1, 3 -> 4개
        //4 -> 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1 -> 7개
        //5 -> 11111, 1112, 1121, 1211, 2111, 221, 212, 122, 32, 23, 113, 131, 311 -> 13개

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(doDP(input));
        }
    }

    //top-down
    static int doDP(int input) {
        if (input < 4 || dp[input] != 0) {
            return dp[input];
        }else {
            return doDP(input - 1) + doDP(input - 2) + doDP(input - 3);
        }
    }
}
