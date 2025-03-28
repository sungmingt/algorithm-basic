package basic.algorithm.baekjoon.retry.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2293_DP {

    static int N, K;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N + 1];
        dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(br.readLine());
            coins[i] = input;
        }

        //1원부터 차례로 K원까지 만들 수 있는 경우의 수를 구한다.
        //각 동전의 값만큼은 항상 만들 수 있고, 그 이외에는 해당 동전의 값을 제외하고 만들 수 있는 경우의 수와 같다.

        //dp[i] = v -> v는 i원을 만들 수 있는 경우의 수이다.
        //dp[i] = dp[i] + dp[i - coin]

        dp[0] = 1;

        for(int i = 1 ; i <= N; i++) {
            int coinVal = coins[i];

            for (int j = coinVal; j <= K; j++)
                dp[j] += dp[j - coinVal];
        }

        System.out.println(dp[K]);
    }
}
