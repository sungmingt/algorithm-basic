package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10798_simulation {

    static String[] words = new String[5];
    static int maxWordLength;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            words[i] = input;
            maxWordLength = Math.max(input.length(), maxWordLength);
        }

        for (int i = 0; i < maxWordLength; i++) {
            for (int k = 0; k < 5; k++) {
                //해당 단어에 i번째 요소가 있는 경우에만 출력
                if (words[k].length() > i) {
                    answer.append(words[k].charAt(i));
                }
            }
        }

        System.out.println(answer);
    }
}
