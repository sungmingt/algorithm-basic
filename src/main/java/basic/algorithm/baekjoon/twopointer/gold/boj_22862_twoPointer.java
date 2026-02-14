package basic.algorithm.baekjoon.twopointer.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_22862_twoPointer {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int oddCount = 0;
        int max = 0;

        for (int right = 0; right < N; right++) {
            if (arr[right] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > K) {
                if (arr[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }

            //현재 구간에서의 짝수 개수
            int evenCount = (right - left + 1) - oddCount;
            max = Math.max(max, evenCount);
        }

        System.out.println(max);
    }
}
