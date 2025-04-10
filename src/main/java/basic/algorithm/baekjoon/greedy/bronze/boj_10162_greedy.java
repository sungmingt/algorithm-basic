package basic.algorithm.baekjoon.greedy.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10162_greedy {

    static int time;
    static int[] buttons = {300, 60, 10};
    static int[] pressCount;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        time = Integer.parseInt(br.readLine());
        pressCount = new int[3];

        int i = 0;

        while (time > 0 && i < 3) {
            if (buttons[i] <= time) {
                pressCount[i]++;
                time -= buttons[i];
            } else {
                i++;
            }
        }

        if(time > 0) sb.append(-1);
        else {
            for (int c : pressCount) {
                sb.append(c).append(" ");
            }
        }

        System.out.println(sb);
    }
}
