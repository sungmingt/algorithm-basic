package basic.algorithm.baekjoon.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10942_DP {

    static int N, M;
    static int[] numbers;
    static boolean[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        dp = new boolean[N + 1][N + 1];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //set
        setDP(numbers, numbers.length);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());

            sb.append(dp[startIdx][endIdx] ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

    static void setDP(int[] numbers, int length) {
        for (int i = 1; i < length; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 2; i < length; i++) {
            for (int k = 1; k < length - i; k++) {
                if (numbers[k] == numbers[k + i] && dp[k + 1][k + i - 1]) {
                    dp[k][k + i] = true;
                }
            }
        }
    }
}
