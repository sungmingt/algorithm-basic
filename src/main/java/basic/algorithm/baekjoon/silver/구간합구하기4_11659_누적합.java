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

        // {1, 2, 3, 4, 5}
        // {1, 3, 6, 10, 15}
        // {1, (1) + 2, (1+2) + 3, (6+4), (10+5)
        for (int i = 1; i < numberList.length; i++) { //누적합 계산
            numberList[i] += numberList[i-1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt(); // 1
            int end = sc.nextInt();       // 3
            int sum = 0;

            sum = numberList[end] - numberList[start - 1];

            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
