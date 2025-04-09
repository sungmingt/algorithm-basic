package basic.algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_17413_str {

    static String str;
    static Stack<Character> word;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        word = new Stack<>();

        //문자열의 처음부터 시작
        //차례로 stack에 push

        //공백 또는 태그가 나오면 -> stack의 값들을 차례로 꺼내서 정답에 이어붙인다.
        //공백이 나온다 -> 공백을 그대로 이어붙인다.
        //태그가 나온다 -> 태그가 끝날때까지 그대로 이어붙인다.

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '<') {
                flipAndWrite();
                sb.append(c);

                while (true) {
                    i++;

                    char t = str.charAt(i);
                    sb.append(t);

                    if (t == '>')break;
                }

            } else if (c == ' ') {
                flipAndWrite();
                sb.append(c);
            } else {
                word.push(c);
            }
        }

        flipAndWrite();
        System.out.println(sb);
    }

    static void flipAndWrite() {
        while (!word.isEmpty()) {
            sb.append(word.pop());
        }
    }
}
