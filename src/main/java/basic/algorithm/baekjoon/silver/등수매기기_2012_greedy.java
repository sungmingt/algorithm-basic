package basic.algorithm.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class 등수매기기_2012_greedy {

    public static void main(String[] args) {
        long result = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] expectedRatings = new int[N];

        for (int i = 0; i < N; i++) {
            expectedRatings[i] = sc.nextInt();
        }

        //불만도(|실제 순위 - 예상 순위|) 가 최소가 되어야 한다
        //실제 순위 : 1,2,3,4,5등
        //예상 순위 : 오름차순 나열

        Arrays.sort(expectedRatings);

        for (int i = 0; i < N; i++) {
            result += Math.abs(expectedRatings[i] - (i + 1));
        }

        System.out.println(result);
    }
}
