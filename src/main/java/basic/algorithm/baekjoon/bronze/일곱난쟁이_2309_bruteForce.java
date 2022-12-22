package basic.algorithm.baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_2309_bruteForce {  //모든 난쟁이 키의 합 - 난쟁이1 - 난쟁이2 = 100인 경우를 찾는다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];

        int sum = 0;  //모든 난쟁이 키의 합
        int fakeHeight1 = 0;  //가짜 난쟁이 1
        int fakeHeight2 = 0;  //가짜 난쟁이 2

        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i];
        }

        for (int i = 0; i < heights.length-1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    fakeHeight1 = heights[i];
                    fakeHeight2 = heights[j];

                    Arrays.sort(heights);
                    for (int a = 0; a < heights.length; a++) {
                        if(heights[a] == fakeHeight1 || heights[a] == fakeHeight2) continue;
                        System.out.println(heights[a]);
                    }

                    return;
                }
            }
        }
    }
}
