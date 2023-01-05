package basic.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = sc.nextInt();

        Integer[] coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());
        //{5, 2, 1}
        //5, 5
        //5, 2, 2, 1
        //5, 2, 1, 1, 1
        //5, 1, 1, 1, 1, 1

        //큰 수 부터 total / coin 의 결과부터 줄여가며 구한다.
        //먼저, total / coin 이 나누어떨어질 경우 count++ 해준다.
        //나누어 떨어지지 않을 경우,

        int count = 0;
        int i = 0;
        while (i < coins.length) {

            Integer standard = coins[i];
            int k = 0;
            if(total % standard == 0) count++;

            while (k <= coins.length) {
                int coinCount = total / standard;
                total -= coinCount * coins[k];
            }

        }
    }
}
