package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼_10872_재귀 {

    static int sum = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }

    public static int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
