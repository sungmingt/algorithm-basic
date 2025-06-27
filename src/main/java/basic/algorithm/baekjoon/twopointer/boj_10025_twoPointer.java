package basic.algorithm.baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10025_twoPointer {

    static int N, K;
    static int[] arr = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int amount = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            arr[location] = amount;
        }

        //탐색 범위 : K ~ arr.length-1-K

        int max = 0;

        //init max
        for (int i = 0; i < K * 2 + 1; i++) {
            //!!! K가 범위를 벗어나는 경우 고려
            if (i >= arr.length) break;
            max += arr[i];
        }

        int cur = max;

        //투 포인터 탐색
        for (int i = K + 1; i < arr.length - K; i++) {
            int prev = arr[i - K - 1];
            int next = arr[i + K];

            cur += next - prev;
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}
