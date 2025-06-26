package basic.algorithm.baekjoon.bruteForce.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16439_bruteForce {

    static int N, M;
    static int[][] preferences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        preferences = new int[N][M];

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < M; k++) {
                preferences[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        //M개 중 3개를 뽑아서 만족도의 합이 가장 높도록

        int max = 0;

        for (int i = 0; i < M - 2; i++) {
            for (int k = i + 1; k < M - 1; k++) {
                for (int p = k + 1; p < M; p++) {

                    int cur = 0;

                    //회원들의 최대 만족도 합 구하기
                    for (int idx = 0; idx < N; idx++) {
                        cur += Math.max(Math.max(preferences[idx][i], preferences[idx][k]), preferences[idx][p]);
                    }

                    max = Math.max(max, cur);
                }
            }
        }

        System.out.println(max);
    }
}
