package basic.algorithm.baekjoon.이분탐색;

import java.util.Scanner;

public class 나무자르기_이분탐색 {

    public static void main(String[] args) {
        //나무 M 미터가 필요
        //H : 톱날의 높이
        //나무의 높이 > H 일 경우에만 잘린다. 아닌 경우에는 나무 높이 그대로.

        //적어도 M 미터의 나무를 위해 필요한 절단기 높이(H)의 최대값 => Upper Bound
        Scanner sc = new Scanner(System.in);

        //나무의 개수(입력수)
        int N = sc.nextInt();
        //필요한 나무 길이
        int M = sc.nextInt();

        int[] arr = new int[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) max = arr[i];
        }

        long mid = 0;
        long min = 0;

        //이분 탐색의 기준 값 : 절단했을 때의 길이의 합(totalLength)
        //움직여야 할 값(mid) : 절단하는 톱날의 길이
        while (min < max) {
            mid = (min + max) / 2;
            long totalLength = 0;

            for (int i = 0; i < arr.length; i++) {
                totalLength += (arr[i] > mid) ? arr[i] - mid : 0;
            }

            //필요한 길이보다 크다면 => 절단 높이가 작다는 것 => mid가 커져야 함
            if (totalLength >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}
