package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대값_2562 {

    static int max = 0;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > max) {
                max = num;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
