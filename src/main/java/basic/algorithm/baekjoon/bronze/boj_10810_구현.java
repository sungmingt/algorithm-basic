package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10810_구현 {

    static int N, M;
    static int[] buckets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        buckets = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            //공이 있으면 빼고 넣는다.
            for (int i = from; i <= to; i++) {
                buckets[i] = num;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<buckets.length; i++) {
            sb.append(buckets[i]).append("\n");
        }

        System.out.println(sb);
    }
}
