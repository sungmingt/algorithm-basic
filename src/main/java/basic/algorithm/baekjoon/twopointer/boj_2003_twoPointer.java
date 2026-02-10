package basic.algorithm.baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003_twoPointer {

    static int N, M;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //포인터 가운데에서 시작? X

        //모두 자연수이기 때문에, 포인터를 올리던 내리던 합은 증가.
        //그리고 모든 범위를 커버해야하기 때문에, 범위를 늘리기만 하는게 아니라, 범위를 이동해야 함.

        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {
            if (sum >= M) {
                if (sum == M) count++;
                sum -= arr[left++];
            } else {
                if (right == N) break;
                sum += arr[right++];
            }
        }

        System.out.println(count);
    }
}
