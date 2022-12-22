package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 거스름돈_5585_greedy {

    public static void main(String[] args) {  //최소 거스름돈 개수 구하기
        Scanner sc = new Scanner(System.in);
        int payment = 1000;
        int price = sc.nextInt();

        //거스름돈
        int remain = payment - price;

        //동전
        int[] coins = {500, 100, 50, 10, 5, 1};

        //지불한 동전 개수
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if(remain == 0) break;

            while (remain >= coins[i]) {
                remain -= coins[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
