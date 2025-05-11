package basic.algorithm.baekjoon.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2073_dp {

    static int D, P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        //dp[i] : i 길이를 만들 수 있는 값 중 최대 용량
        dp = new int[D + 1];
        dp[0] = Integer.MAX_VALUE;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 뒤에서부터 업데이트 (중복 사용 방지)

            //현재 배관과 기존의 다른 배관을 이어 붙여서 만들수 있는 경우의 수를 갱신시킨다. (배관은 2개 이상이 될수도 있다)
            //ex) 7-3=4 3 2 1 0  ->  현재 길이(3)와 다른 배관을 이어붙여서 만들수 있는 경우의 수를 갱신
            //이때, 다른 배관의 길이(j)를 만들수 있는 경우가 이미 존재할때(dp[j] > 0), 그 값을 갱신

            for (int j = D - L; j >= 0; j--) {
                if (dp[j] > 0) {
                    int minCapacity = Math.min(dp[j], C);
                    dp[j + L] = Math.max(dp[j + L], minCapacity);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
