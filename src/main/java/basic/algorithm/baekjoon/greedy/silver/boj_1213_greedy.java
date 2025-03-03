package basic.algorithm.baekjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1213_greedy {

    static int[] alpha = new int[26];
    static int oddAlphabetsCnt;
    static char oddAlphabet;
    static String input;
    static StringBuilder palindrome = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        //주어진 이름의 순서를 조정하여 팰린드롬을 만들 수 있는지
        //가능 -> 팰린드롬 만들어서 출력 (여러개일 경우 사전순 앞선것으로)
        //불가능 -> "I'm Sorry Hansoo"

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            alpha[c - 65]++;
        }

        //1. 팰린드롬을 만들 수 있는지 확인하기
        //홀수인 알파벳이 0개 또는 1개 여야 팰린드롬을 만들 수 있다.
        //AABBCCD -> ABCDCBA
        //AABBBCCCC -> CBACBCABC, ACBCBCBCA
        //나머지 짝수인 알파벳들은 개수에 상관없이 모두 만들수 있다..!

        //2. 팰린드롬 만들기(여러개일 경우 오름차순 첫번째)
        //모든 알파벳을 (알파벳 개수)/2개 만큼 문자열에 담는다. (front)
        //홀수인 알파벳이 있으면 가운데에 배치 (mid)
        //front를 reverse 하여 뒤에 배치 (end)

        //홀수개인 알파벳 개수 찾기 (팰린드롬인지 확인)
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) {
                oddAlphabetsCnt++;
                oddAlphabet = (char) (i + 65);

                if (oddAlphabetsCnt > 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        StringBuilder front = new StringBuilder();

        //팰린드롬 만들기
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > 0) {
                int alphaCnt = alpha[i] / 2;
                char ch = (char) (i + 65);

                for (int k = 0; k < alphaCnt; k++) {
                    front.append(ch);
                }
            }
        }

        //input front
        palindrome.append(front);

        //input mid
        if (oddAlphabetsCnt == 1) {
            palindrome.append(oddAlphabet);
        }

        //input end
        String end = front.reverse().toString();
        palindrome.append(end);

        System.out.println(palindrome);
    }
}