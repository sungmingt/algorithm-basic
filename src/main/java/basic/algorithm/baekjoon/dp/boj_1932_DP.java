package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1932_DP {

    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k <= i; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(doDP(0, 0));
    }

    //top-down
    //idx=0 일때, 다음 depth의 0, 1 만 탐색 가능
    static int doDP(int depth, int idx) {
        //최하위 노드 도착 시 해당 값을 return
        if (depth == N - 1) {
            return arr[depth][idx];
        }

        if (dp[depth][idx] == 0) {
            dp[depth][idx] = Math.max(
                    doDP(depth + 1, idx) + arr[depth][idx],
                    doDP(depth + 1, idx + 1) + arr[depth][idx]
            );
        }

        return dp[depth][idx];
    }
}
