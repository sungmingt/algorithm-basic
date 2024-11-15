package basic.algorithm.baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3273_투포인터 {

    static int N, X;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int result = 0;

        //1 2 3 4 5 6 7 8 9 10
        //1. 수열 오름차순 정렬
        //arr[0]과 arr[N-1]을 더한 값을 X와 비교한다.
        //X보다 작을 경우 start++, 클 경우 end--
        //start >= end가 되면 break

        while (start < end) {
            int curSum = arr[start] + arr[end];

            if (curSum == X) {
                result++;
                start++;
            } else if (curSum < X) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }
}
