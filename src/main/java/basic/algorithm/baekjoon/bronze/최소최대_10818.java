package basic.algorithm.baekjoon.bronze;

import java.util.Scanner;

public class 최소최대_10818 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {
            int number = sc.nextInt();

            if(number>= max) max = number;
            if(number<= min) min = number;
        }

        System.out.println(min + " " + max);
    }
}
