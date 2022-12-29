package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 블랙잭_2798_bruteForce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //카드 입력 개수
        int M = sc.nextInt(); //최대 숫자

        int maxSum = 0; //최대값
        int[] cardList = new int[N];
        for (int i = 0; i < N; i++) {
            cardList[i] = sc.nextInt();
        }

        for (int i = 0; i < cardList.length - 2; i++) {
            for (int j = i + 1; j < cardList.length - 1; j++) {
                for (int k = j + 1; k < cardList.length; k++) {
                    int sum = cardList[i] + cardList[j] + cardList[k];
                    if (sum <= M && sum > maxSum) maxSum = sum;
                }
            }
        }

        System.out.println(maxSum);
    }
}
