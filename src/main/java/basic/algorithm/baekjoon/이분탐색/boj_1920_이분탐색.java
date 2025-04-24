package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920_이분탐색 {

    static int N, M;
    static StringTokenizer st;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        //input
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //sort
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //input + search
        for (int i = 0; i < M; i++) {
            //input
            int target = Integer.parseInt(st.nextToken());

            //search
            int start = 0;
            int end = arr.length - 1;
            int mid = (start + end) / 2;
            boolean isContained = false;

            while (start <= end) {
                if (arr[mid] == target) {
                    isContained = true;
                    break;
                } else if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

                mid = (start + end) / 2;
            }

            sb.append(isContained ? 1 : 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
