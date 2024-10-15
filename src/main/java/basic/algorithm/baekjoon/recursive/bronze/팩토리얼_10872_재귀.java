package basic.algorithm.baekjoon.recursive.bronze;

import java.util.Scanner;

public class 팩토리얼_10872_재귀 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(factorial(N));
    }

    private static int factorial(int num) {
        if (num <= 1) return 1;
        return num * factorial(num - 1);
    }
}