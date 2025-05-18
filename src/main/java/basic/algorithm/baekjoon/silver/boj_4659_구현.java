package basic.algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj_4659_구현 {

    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    static Set<Character> vowels = new HashSet<>();
    static String end = "end";
    static String acceptableClause = " is acceptable.";
    static String unAcceptableClause = " is not acceptable.";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //hashSet input
        for (char v : vowel) {
            vowels.add(v);
        }

        while (true) {
            String pw = br.readLine();
            if (pw.equals(end)) break;

            boolean isAcceptable = validatePassword(pw);

            sb.append("<").append(pw).append(">");
            sb.append(isAcceptable ? acceptableClause : unAcceptableClause);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean validatePassword(String password) {
        boolean isVowelContained = false;
        int vowelStack = 0;
        int consStack = 0;
        char prev = ' ';

        for (int i = 0; i < password.length(); i++) {
            char letter = password.charAt(i);

            if (vowels.contains(letter)) {
                isVowelContained = true;
                vowelStack++;
                consStack = 0;
            } else {
                consStack++;
                vowelStack = 0;
            }

            //2개 연속 불가 (e,o만 가능)
            if (letter == prev && !(letter == 'e' || letter == 'o')) {
                return false;
            }

            //(자음 or 모음) 3개 연속 불가
            if (vowelStack == 3 || consStack == 3) {
                return false;
            }

            prev = letter;
        }

        return isVowelContained;
    }
}
