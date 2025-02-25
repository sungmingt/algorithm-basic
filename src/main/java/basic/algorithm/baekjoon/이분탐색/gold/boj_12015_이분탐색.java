package basic.algorithm.baekjoon.이분탐색.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12015_이분탐색 {

    static int N;
    static int[] arr;
    static int[] LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            if (LIS[lengthOfLIS - 1] < key) {
                LIS[lengthOfLIS] = key;
                lengthOfLIS++;
            } else {

                //10 20 30 15 13
                //10 15 30 13
                //->10 13 15 30
                //  start = 0, end = lengthOfLIS, mid = (start+end) / 2
                //  i 이전의 값들 중 key 값보다 큰 수 중 가장작은 값을 찾을떄까지

                int start = 0;
                int end = lengthOfLIS;

                while (start < end) {
                    int mid = (start + end) / 2;

                    if (LIS[mid] < key) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }

                //찾은 인덱스의 값을 key값으로 대체한다.
                LIS[start] = key;
            }
        }

        System.out.println(lengthOfLIS);
    }
}
