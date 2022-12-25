package basic.algorithm.baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class 커트라인_25305_sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] scoreList = new int[N];

        for (int i = 0; i < N; i++) {
            scoreList[i] = sc.nextInt();
        }

        Arrays.sort(scoreList);

        System.out.println(scoreList[scoreList.length-k]);
    }
}
