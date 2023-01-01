package basic.algorithm.programmers.lv2;

import java.util.Arrays;

public class 카펫_lv2_완전탐색 {

    public String solution(int brown, int yellow) {
        int total = brown + yellow;
        int row = 3; //가로는 세로보다 크거나 같다 (row >= col)
        int col = 3;

        while (true) {
            while (row >= col) {
                if(row * col == total && (row - 2) * (col - 2) == yellow){
                    return Arrays.toString(new int[]{row, col});
                }

                col++;
            }

            row ++;
            col = 3;
        }
    }
    //(가로 - 2) * (세로 - 2) = yellow
    //가로 * 세로 = brown + yellow

    //24 24	 [8, 6]
    //--------
    //--------
    //--------
    //--------
    //--------
    //--------
}
