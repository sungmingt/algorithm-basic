package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 최댓값_2566 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hang = 0;
        int yul = 0;
        int max = Integer.MIN_VALUE;

        //결과는 1~9 행/열 이기 떄문에 index + 1 한 결과를 출력해야 한다.
        //풀이 1. 입력 받을때마다 비교하고, max에 최댓값을 저장, hang, yul 에 행/열을 저장한다.
        //풀이 2. 2차원 배열에 모두 저장한 후 정렬하여 값을 도출한다.

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = sc.nextInt();
                if (num > max) {
                    max = num;
                    hang = i;
                    yul = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((hang+1) + " " + (yul+1));
    }
}
