package basic.algorithm.baekjoon.recursive.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀의귀재_25501_재귀 {

    static int N;
    static int callCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            callCount = 0;
            String word = br.readLine();

            int bool = isPalindrome(word);
            sb.append(bool + " " + callCount + "\n");
        }

        System.out.println(sb);
    }

    static int isPalindrome(String word) {
        return recursion(word, 0, word.length() - 1);
    }

    private static int recursion(String word, int st, int end) {
        callCount++;

        if (st >= end) {
            return 1;
        }

        if (word.charAt(st) != word.charAt(end)) {
            return 0;
        }

        return recursion(word, st + 1, end - 1);
    }
}
