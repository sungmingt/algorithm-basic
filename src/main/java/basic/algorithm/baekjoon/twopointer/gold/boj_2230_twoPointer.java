package basic.algorithm.baekjoon.twopointer.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2230_twoPointer {

    static int N, M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //주의
        //  같은 수일수도 있다.
        //  M은 0일수도 있다.

        //0,1 부터 차례로 탐색
        //두 수의 차이가 M보다 작으면 end++;
        //두 수의 차이가 M보다 커지면, 해당 수를 최소값으로 초기화시키고 start++;
        //end < arr.length 일 동안 탐색한다.

        //여기서, start == end인 상황이 나올 수 있다.
        //  ex) [1 2 2 3 4], M=1
        //  -> start == end 일경우, end++

        //sort
        Arrays.sort(arr);

        int start = 0;
        int end = 1;

        while (start < arr.length - 1 && end < arr.length) {
            if (start == end) {
                end++;
                continue;
            }

            int diff = arr[end] - arr[start];

            if (diff < M) {
                end++;
            } else {
                answer = Math.min(answer, diff);
                start++;
            }
        }

        System.out.println(answer);
    }
}
