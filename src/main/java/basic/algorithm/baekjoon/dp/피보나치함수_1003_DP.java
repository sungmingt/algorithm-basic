package basic.algorithm.baekjoon.dp;

import java.util.Scanner;

public class 피보나치함수_1003_DP { //시간초과!! DP 알고리즘 다시 풀어보기

    static int zeroCount;
    static int oneCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] DP = new int[41];
        DP[0] = 0;
        DP[1] = 1;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(DP[num] == 0) zeroCount++;
            if(DP[num] == 1) oneCount++;
        }
    }

    public static int fibonacci(int num) {
        if (num == 0) {
            zeroCount++;
            return 0;
        } else if (num == 1) {
            oneCount++;
            return 1;
        } else {
            return fibonacci(num-1) + fibonacci(num-2);
        }
    }

    public static void countFibonacci(int num) {
        fibonacci(num);
        System.out.println(zeroCount + " " + oneCount);
        zeroCount = 0;
        oneCount = 0;
    }
}
