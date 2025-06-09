package basic.algorithm.baekjoon.twopointer.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2473_투포인터 {

    static int N;
    static int[] arr;
    static long answer = Long.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

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

        //[-2, 6, -97, -6, 98]
        //[-97, -6, -2, 6, 98]

        //절대값이 가장 가까운것? x -> (절대값이 멀어도 3번째 값으로 모두 상쇄 가능)
        //하나를 선택. 나머지 두개의 합이 첫번째 값의 반대와 가장 비슷하도록
        //두번째도 선택하고 세번쨰 값을 이분 탐색..?
        //  -> 첫번째 값만 선택하고, 나머지 두 값을 투 포인터로 탐색

        //투 포인터 탐색
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                long absSum = Math.abs(sum);

                if (absSum < answer) {
                    answer = absSum;
                    sb.setLength(0);
                    sb.append(arr[i]).append(" ").append(arr[left]).append(" ").append(arr[right]);
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(sb);
    }
}