package basic.algorithm.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1051_bruteForce {

    static int row, col;
    static int[][] rectangle;
    static int size;
    static boolean hasFound;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        row = Integer.parseInt(s[0]);
        col = Integer.parseInt(s[1]);
        size = Math.min(col, row);

        rectangle = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] split = br.readLine().split("");

            for (int k = 0; k < col; k++) {
                rectangle[i][k] = Integer.parseInt(split[k]);
            }
        }

        //row 4, col 3
        //1 2 3 4
        //1 2 3 4
        //1 2 3 4
        //  -> 최대 넓이 : 3x3 = 9
        //  -> 탐색할 곳 : 00, 01

        //  -> 두번째 최대 넓이 : 2x2 = 4
        //  -> 탐색할 곳 : 00, 01, 02, 10, 11, 12
        //      -> 탐색은 [0][0] ~ [row-size][col-size] 까지 하면 된다.

        //탐색 방법은 [r][c] == [r + size - 1][c] == [r][c + size - 1] == [r + size - 1][c + size - 1]

        //먼저, 가장 큰 넓이가 나올수 있는 경우부터 탐색한다.
        //  -> 정사각형을 찾으면 그게 답이 된다.

        while (size > 1) {
            for (int i = 0; i <= row - size; i++) {
                for (int k = 0; k <= col - size; k++) {
                    if(search(i, k, size)) {
                        hasFound = true;
                        break;
                    }
                }

                if(hasFound) break;
            }

            if(hasFound) break;
            size--;
        }

        System.out.println(size * size);
    }

    static boolean search(int r, int c, int size) {
        int standard = rectangle[r][c];

        return (standard == rectangle[r + size - 1][c]
                && standard == rectangle[r][c + size - 1]
                && standard == rectangle[r + size - 1][c + size - 1]);
    }
}
