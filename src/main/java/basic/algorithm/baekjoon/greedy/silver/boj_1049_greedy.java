package basic.algorithm.baekjoon.greedy.silver;

import java.io.*;
import java.util.*;

public class boj_1049_greedy {

    static int N, M;
    static int minPackageCost = Integer.MAX_VALUE;
    static int minOneCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //패키지/낱개 가격의 최솟값을 구하고, 해당 가격으로 적절히 분배하여 구매한다.

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            minPackageCost = Math.min(minPackageCost, p);
            minOneCost = Math.min(minOneCost, o);
        }

        int minTotalCost = 0;

        //낱개만 구매
        int cost1 = minOneCost * N;
        //세트로만 구매 (남는 줄 생겨도 무관)
        int cost2 = ((N + 5) / 6) * minPackageCost;
        //세트 + 낱개
        int cost3 = (N / 6) * minPackageCost + (N % 6) * minOneCost;

        minTotalCost = Math.min(cost1, Math.min(cost2, cost3));
        System.out.println(minTotalCost);
    }
}
