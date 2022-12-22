package basic.algorithm.baekjoon.bronze;

import java.util.Scanner;

public class 지능형기차_2460 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 10;
        int max = 0;
        int current = 0;

        while (total > 0) {
            int out = sc.nextInt();
            int in = sc.nextInt();

            current = current - out + in;
            if (current > max) {
                max = current;
            }

            total --;
        }

        System.out.println(max);
    }
}
