package basic.algorithm.baekjoon.backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_6443_backtracking {

    static int N;
    static boolean[] isUsed;
    static String[] alphabets;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N --> 0) {
            alphabets = br.readLine().split("");

            //sort
            Arrays.sort(alphabets); //사전순 출력

            isUsed = new boolean[alphabets.length];
            makeWord(new StringBuilder());
        }

        System.out.println(sb);
    }

    static void makeWord(StringBuilder curWord) {
        if (curWord.length() == alphabets.length) {
            sb.append(curWord).append("\n");
            return;
        }

        String prev = ""; // 이전에 사용한 문자 저장

        for (int i = 0; i < alphabets.length; i++) {
            if (isUsed[i]) continue;
            if (alphabets[i].equals(prev)) continue;

            isUsed[i] = true;
            curWord.append(alphabets[i]);
            makeWord(curWord);
            curWord.deleteCharAt(curWord.length() - 1);
            isUsed[i] = false;
            prev = alphabets[i];
        }
    }
}

