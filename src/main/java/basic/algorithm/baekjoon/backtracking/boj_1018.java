package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018 {

    static int N, M;
    static char[][] board;
    static int minPaint = 51;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        //input
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();

            for (int k = 0; k < M; k++) {
                board[i][k] = chars[k];
            }
        }

        //8x8로 순차적으로 탐색한다 -> 반복문
        //맨 왼쪽 위가 W일 경우와 B일 경우 두 가지 탐색

        //search
        for (int i = 0; i <= N - 8; i++) {
            for (int k = 0; k <= M - 8; k++) {
                int paintCount = paint(i, k);
                minPaint = Math.min(minPaint, Math.min(paintCount, 64 - paintCount));
            }
        }

        System.out.println(minPaint);
    }

    static int paint(int x, int y) {
        int sum = 0;
        boolean isWhite = board[x][y] == 'W';

        for (int i = x; i < x + 8; i++) {
            for (int k = y; k < y + 8; k++) {
                if ((board[i][k] == 'B' && isWhite) || (board[i][k] == 'W' && !isWhite)) {
                    sum++;
                }

                isWhite = !isWhite;
            }

            isWhite = !isWhite;
        }

        return sum;
    }
}


