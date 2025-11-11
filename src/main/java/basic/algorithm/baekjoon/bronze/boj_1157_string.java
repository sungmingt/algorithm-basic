package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1157_string {

    static int[] alphabets = new int[26];
    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toUpperCase().toCharArray();

        //ascii code를 활용해 배열에 저장 후, 가장 많이 사용된 알파벳을 출력한다.

        for (char c : input) {
            alphabets[c - 65]++;
        }

        int mostUsedIdx = 0;
        int maxCnt = 0;
        boolean isMultiple = false;

        for (int i = 0; i < alphabets.length; i++) {
            int cnt = alphabets[i];

            if (maxCnt < cnt) {
                maxCnt = cnt;
                mostUsedIdx = i;
                isMultiple = false;
            } else if (maxCnt == cnt) {
                isMultiple = true;
            }
        }

        if (isMultiple) {
            System.out.println("?");
        } else {
            System.out.println(Character.toChars(mostUsedIdx + 65));
        }
    }
}
