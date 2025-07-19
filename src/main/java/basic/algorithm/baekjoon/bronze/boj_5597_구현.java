package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5597_구현 {

    static boolean[] numbers = new boolean[31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[num] = true;
        }

        for (int i = 1; i < numbers.length; i++) {
            if(!numbers[i]) System.out.println(i);
        }
    }
}
