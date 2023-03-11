package basic.algorithm.baekjoon.greedy;

import java.util.Scanner;

public class 돌게임_9655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //1 -> 이김
        //2 -> 짐
        //3 -> 이김
        //cur = 4 -> 짐
        //cur = 5 -> 이김
        //cur = 6 -> 짐

        //7 -> 1을 가져감 -> 6 -> 이김
        //7 -> 3을 가져감 -> 4 -> 이김

        //8 -> 1을 가져감 -> 7 -> 짐
        //8 -> 3을 가져감 -> 5 -> 짐

        //idx : 0부터 시작
        //홀수 : SK, 짝수 : CY

        if(N % 2 != 0){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
