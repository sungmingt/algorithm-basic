package basic.algorithm.baekjoon.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17404_dp {

    static int N;
    static int[][] costs;
    static int[][] dp;
    static int INF = 1000 * 1000;
    static int answer = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        costs = new int[N][3];
        dp = new int[N][3];

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken()); //R
            costs[i][1] = Integer.parseInt(st.nextToken()); //G
            costs[i][2] = Integer.parseInt(st.nextToken()); //B
        }

        //첫번째 집을 각각 R/G/B로 칠하는 경우
        for (int k = 0; k < 3; k++) {

            //R,G,B 로 칠하는 경우 각 색을 제외한 나머지는 max로 초기화
            for (int i = 0 ; i < 3; i++) {
                if(i == k) dp[0][i] = costs[0][i];
                else dp[0][i] = INF;
            }

            //만일 첫번째 집을 R로 칠했다.
            //dp[1][0] = MAX + cost
            //dp[1][1] = dp[0] + cost
            //dp[1][2] = dp[0] + cost

            //dp[2][0] = dp[1] + cost
            //dp[2][1] = dp[1] + cost
            //dp[2][2] = dp[1] + cost

            for (int p = 1; p < N; p++) {
                dp[p][0] = Math.min(dp[p - 1][1], dp[p - 1][2]) + costs[p][0];
                dp[p][1] = Math.min(dp[p - 1][0], dp[p - 1][2]) + costs[p][1];
                dp[p][2] = Math.min(dp[p - 1][0], dp[p - 1][1]) + costs[p][2];
            }

            //마지막 집은 첫번째 집과 달라야 하기 때문에, 서로 색이 다를때만 최솟값 초기화
            for (int i = 0; i < 3; i++) {
                if(i != k) {
                    answer = Math.min(answer, dp[N - 1][i]);
                }
            }
        }

        System.out.println(answer);
    }
}
