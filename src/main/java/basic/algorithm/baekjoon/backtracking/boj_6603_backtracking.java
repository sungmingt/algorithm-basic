package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603_backtracking {

    static int[] numbers;
    static boolean[] isSelected;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0) return;

            numbers = new int[k];
            isSelected = new boolean[k];

            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            //k개중 6개를 고를 수 있는 모든 경우의 수를 출력
            backtracking(0, 0);

            System.out.println();
        }
    }

    static void backtracking(int start, int selectCnt) {
        if (selectCnt == 6) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < numbers.length; i++) {
                if (isSelected[i]) {
                    sb.append(numbers[i]).append(" ");
                }
            }

            System.out.println(sb);
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            isSelected[i] = true;
            backtracking(i + 1, selectCnt + 1);
            isSelected[i] = false;
        }
    }
}
