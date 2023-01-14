package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 약수의합2_showMeTheCode_연습문제 {

    static long total;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //g(N)에서 k의 개수 : N/k
        //즉, N이 7이라고 하면
        //(1) 7개, (2) 3개, (3) 2개, (4) 1개, (5) 1개, (6) 1개, (7) 1개이다.
        //답은 (1x7) + (2x3) ... 가 된다.

        for (int i = 1; i <= N; i++) {
            total += (long) i * (N / i);
        }

        System.out.println(total);
    }
}
