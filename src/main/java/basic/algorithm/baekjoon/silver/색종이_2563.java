package basic.algorithm.baekjoon.silver;

import java.util.Scanner;

public class 색종이_2563 {

    public static void main(String[] args) {
        //도화지
        boolean[][] sketch = new boolean[101][101];
        //넓이
        long total = 0;

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        //1. 모든 index를 false로 설정
        //2. 입력받은 색종이 부분을 true로 설정 -> 넓이++  (1x1 단위로 계산한다고 보면 된다)
        //3. 중복되는 부분이 있을 수 있다 -> false인지 check

        while (count > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    //false인 경우
                    if (!sketch[i][j]) {
                        sketch[i][j] = true;
                        total ++;
                    }
                }
            }
            count--;
        }

        System.out.println(total);
    }
}
