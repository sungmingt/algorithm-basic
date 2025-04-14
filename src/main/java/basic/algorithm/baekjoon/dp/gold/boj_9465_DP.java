package basic.algorithm.baekjoon.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465_DP {

    static int T;
    static int[][] stickers;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];
            dp = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 0; k < N; k++) {
                    stickers[i][k] = Integer.parseInt(st.nextToken());
                }
            }

            //stickers[][]를 선택하는 방법
            //1. 번갈아가면서 선택한다.
            //2. i-2번째 0를 선택하고, i-1 선택x, i번째 1 선택
            //그러니까, i번째 요소를 i-2번째 요소와 같은 것을 선택했을때의 값과, 다른 것을 선택했을때의 값을 비교한다.
            //같은 것을 선택하면 i-1번째도 선택 가능, 아니면 선택 불가

            //점화식
            //0번째 값을 선택하는 경우
            //  Math.max(dp[1][i-2] + stickers[0][i], dp[1][i-1] + stickers[0][i]);
            //1번째 값을 선택하는 경우
            //  Math.max(dp[0][i-2] + stickers[1][i], dp[0][i-1] + stickers[1][i]);

            if (N == 1) {
                sb.append(Math.max(stickers[0][0], stickers[1][0]));
            } else {
                dp[0][0] = stickers[0][0];
                dp[1][0] = stickers[1][0];
                dp[1][1] = stickers[0][0] + stickers[1][1];
                dp[0][1] = stickers[1][0] + stickers[0][1];

                for (int i = 2; i < N; i++) {
                    int pick0 = Math.max(dp[1][i - 2], dp[1][i - 1]) + stickers[0][i];
                    int pick1 = Math.max(dp[0][i - 2], dp[0][i - 1]) + stickers[1][i];
                    dp[0][i] = pick0;
                    dp[1][i] = pick1;
                }

                sb.append(Math.max(dp[0][N - 1], dp[1][N - 1]));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
