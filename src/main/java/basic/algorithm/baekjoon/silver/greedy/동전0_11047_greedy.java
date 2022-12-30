package basic.algorithm.baekjoon.silver.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 동전0_11047_greedy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = sc.nextInt();

        Integer[] coinTypes = new Integer[N];
        for (int i = 0; i < coinTypes.length; i++) {
             coinTypes[i] = sc.nextInt();
        }

        Arrays.sort(coinTypes, Comparator.reverseOrder());
        int count = 0;

        for (int i = 0; i < coinTypes.length; i++) {
            if(coinTypes[i] > total) continue;

            while (total > 0) { //도달하기 전까지 동전 사용
                if (total - coinTypes[i] < 0) {
                    break;
                } else {
                    total -= coinTypes[i];
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
