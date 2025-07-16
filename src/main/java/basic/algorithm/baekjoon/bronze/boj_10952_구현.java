package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10952_구현 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isOver(a, b)) break;
            printSum(a, b);
        }
    }

    private static boolean isOver(int a, int b) {
        return a == 0 && b == 0;
    }

    private static void printSum(int a, int b) {
        System.out.println(a + b);
    }
}
