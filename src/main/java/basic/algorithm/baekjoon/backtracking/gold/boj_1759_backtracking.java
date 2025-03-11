package basic.algorithm.baekjoon.backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_backtracking {

    static int L, C;
    static char[] alphabets;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[C];

        //input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }

        //암호는 서로 다른 L개의 알파벳 소문자들로 구성, 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
        //알파벳이 암호에서 증가하는 순서로 배열 (오름차순)
        //가능성 있는 암호를 모두 구하기
        // -> 오름차순 정렬 + 재귀 구현

        //sort
        Arrays.sort(alphabets);

        sb = new StringBuilder();

        generateCode(0, "");
        System.out.println(sb);
    }

    static void generateCode(int idx, String code) {
        if (code.length() == L) {
            validateCode(code);
            return;
        }

        for (int i = idx; i < alphabets.length; i++) {
            generateCode(i + 1, code + alphabets[i]);
        }
    }

    private static void validateCode(String code) {
        int vowelCnt = 0;
        int consonantCnt = 0;

        for (int i = 0; i < code.length(); i++) {
            char letter = code.charAt(i);

            if (isVowel(letter)) vowelCnt++;
            else consonantCnt++;

            if (1 <= vowelCnt && 2 <= consonantCnt) {
                sb.append(code).append("\n");
                break;
            }
        }
    }

    static boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}
