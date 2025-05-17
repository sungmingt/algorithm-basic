package basic.algorithm.baekjoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10986_누적합 {

    static int N, M;
    static long[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new long[M];  // 나머지 0 ~ M-1 카운트
        long sum = 0;
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            sum += num;
            int mod = (int) (sum % M);

            // 음수 나머지 보정
            if (mod < 0) mod += M;

            // 누적합이 M으로 나누어떨어지는 경우
            if (mod == 0) answer++;

            // 이전에 같은 나머지 있었던 횟수 더하기
            answer += count[mod];

            // 현재 나머지 카운트 증가
            count[mod]++;
        }

        System.out.println(answer);
    }
}
