package basic.algorithm.baekjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12904_greedy {

    static String S, T;
    static boolean canMake;

    public static void main(String[] args) throws IOException {
        //역방향 계산(T->S)
        //마지막의 A를 지운다
        //마지막의 B를 지우고, 문자열을 뒤집는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        StringBuilder sb = new StringBuilder(T);

        while (sb.length() > S.length()) {
            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }

            if (sb.toString().equals(S)) {
                canMake = true;
                break;
            }
        }

        System.out.println(canMake ? 1 : 0);
    }
}
