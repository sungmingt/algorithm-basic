package basic.algorithm.baekjoon.sort.silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표정렬하기2_11651_sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        for (int[] ints : arr) {
            System.out.print(ints[0] + " " + ints[1] + "\n");
        }
    }
}
