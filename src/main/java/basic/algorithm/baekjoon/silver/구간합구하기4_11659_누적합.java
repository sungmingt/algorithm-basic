package basic.algorithm.baekjoon.silver;

import java.util.Scanner;

public class 구간합구하기4_11659_누적합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] numberList = new int[N+1];
        for (int i = 1; i < numberList.length; i++) {
            numberList[i] = sc.nextInt();
        }

        for (int i = 1; i < numberList.length; i++) { //누적합 계산
            numberList[i] += numberList[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int result = 0;

            result = numberList[end] - numberList[start - 1];
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}
