package basic.algorithm.baekjoon.knapsack;

import java.util.Scanner;

public class 평범한배낭_12865_knapsack {

    static int[] w;
    static int[] v;
    static int[][] dp;
    static int N;
    static int K;

    public static void main(String[] args) {
        //N개의 물건
        //무게(W), 가치(V)
        //최대 무게 : K

        //배낭에 넣을 수 있는 물건 가치(V)의 최대값

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        w = new int[N + 1];
        v = new int[N + 1];
        //(item, 무게)의 2차원 배열이다.
        dp = new int[N + 1][K + 1];

        //w, v 입력 받기
        for (int i = 1; i < N + 1; i++) {
            int W = sc.nextInt();
            int V = sc.nextInt();

            w[i] = W;
            v[i] = V;
        }

        //1. dp[i][j]는 기본적으로 dp[i - 1][j]의 형태를 띈다.
        //2. 만일, 현재 item의 무게가 현재 index 무게보다 크다면, 그냥 dp[i-1][j]를 입력한다. 해당 무게만큼 담지 못하기 때문이다.
        //  ex) dp[1][3]번째를 입력하는 경우, 만일 w[1]의 값이 3보다 크다면, dp[0][3]을 입력한다.
        //3. 만일, 현재 item의 무게가 현재 index 무게보다 작다면, '이전 item의 가치'와 '(현재 item의 가치) + (이전 item의 (현재 index 무게 - 현재 무게)번째의 가치)'
        //  를 비교해서 더 큰 값을 저장한다.
        //  수식으로 표현하자면, dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]) 이다.
        //  여기서 이전 item의 무게보다 더 이전의 item의 무게가 더 작을 경우, 더 담을 수 있기 때문에 더 이전의 요소도 비교해야하지 않나?
        //  라고 생각할 수 있지만, 그 경우는 이미 앞에서 2번 과정을 거쳤기 때문에 상관없다.

        for (int i = 1; i < N + 1; i++) {

            for (int j = 1; j < K + 1; j++) {
                dp[i][j] = dp[i - 1][j];

                //현재 item의 무게를 담을 수 있다면
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    static int knapsack(int idx) {
        return 0;
    }
}
