package basic.algorithm.baekjoon.twopointer.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253_twoPointer {

    static int N;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //sort
        Arrays.sort(arr);

        //search
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];

            int start = 0;
            int end = arr.length - 1;

            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                }

                if (end == i) {
                    end--;
                    continue;
                }

                int curSum = arr[start] + arr[end];

                if (curSum == target) {
                    answer++;
                    break;
                } else if (curSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(answer);
    }
}
