package basic.algorithm.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class N번째큰수_2693 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();

        while (total > 0) {
            int[] arr = new int[10];

            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            System.out.println(arr[7]);

            total--;
        }
    }

}
