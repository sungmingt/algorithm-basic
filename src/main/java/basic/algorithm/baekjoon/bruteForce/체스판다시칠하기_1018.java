package basic.algorithm.baekjoon.bruteForce;

import java.util.Scanner;

public class 체스판다시칠하기_1018 { //다시 풀어보기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //세로
        int M = sc.nextInt(); //가로

        int[][] board = new int[N][M];

        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();  //W 또는 B
            }
        }

        //완전탐색
        //8x8로 잘라야 하는데, 가장 덜 색칠해도 되는 부분을 잘라야 한다.
        //W B W B W B W B
        //B W B W B W B W
        //W B W B W B W B
        //B W B B B W B W
        //W B W B W B W B
        //B W B W B W B W
        //W B W B W B W B
        //B W B W B W B W

    }
}
