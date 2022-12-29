package basic.algorithm.baekjoon.silver;

import java.util.Scanner;

public class 수열_2559_누적합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //숫자 개수
        int K = sc.nextInt(); //연속된 날짜

        // 3, -2, -4,  -9,   0,  3,  7, 13,  8, -3
        // 3,  1, -3, -12, -12, -9, -2, 11, 19, 16

        //연속 2일 (arr[K] 부터)
        //arr[2]
        //arr[3] - arr[1]
        //arr[4] - arr[2]

        //연속 3일
        //arr[3]
        //arr[4] - arr[1]
        //arr[5]
        //arr[10]
        //(N - K + 1) 번 반복
        int[] arr = new int[N+1];
        for (int i = 1; i < N+1; i++) {  //누적합 배열 생성
            arr[i] = sc.nextInt() + arr[i - 1];
        }

        int max = Integer.MIN_VALUE;
        for (int i = K; i < N + 1; i++) {
            int sum = arr[i] - arr[i - K];
            if(sum > max) max = sum;
        }

        System.out.println(max);
    }
}
