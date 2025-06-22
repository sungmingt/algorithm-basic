package basic.algorithm.baekjoon.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_7579_knapsack {

    static int N, M;
    static int[] memory;
    static int[] cost;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N];
        cost = new int[N];
        dp = new int[10001]; //dp[i] = 비용 i일 때 확보 가능한 최대 메모리

        //input memory
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        //input cost
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        //DP(knapsack)
        //현재 앱 i 를 선택했을때, 비용(j)에서 가져갈수 있는 최대 메모리 수를 저장한다.
        //  ex) j 만큼의 비용으로 가져갈 수 있는 최대 메모리 수(dp[j])는 현재 0이다.
        //  특정 앱 1개를 선택하면, 해당 앱의 비용만큼 차감하고,

        for (int i = 0; i < N; i++) {
            for (int j = 10000; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        // 최소 비용 찾기
        for (int j = 0; j <= 10000; j++) {
            if (dp[j] >= M) {
                System.out.println(j);
                break;
            }
        }
    }
}