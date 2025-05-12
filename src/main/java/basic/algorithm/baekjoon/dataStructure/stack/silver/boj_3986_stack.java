package basic.algorithm.baekjoon.dataStructure.stack.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_3986_stack {

    static int N;
    static int answer;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //개수가 홀수이면 false;
        //stack 활용
        // -> 스택에 단어(A or B)가 있는 상태에서 문자가 교차되면 좋은 단어가 아니다. ex)ABAB or BABA
        //    교차 되더라도 특정 단어가 연속되어 pop 될수있다면 좋은 단어이다. ex) ABAABA
        //  -> 결국 마지막에 스택이 비어있어야 좋은 단어이다.

        for (int i = 0; i < N; i++) {
            stack = new Stack<>();
            String input = br.readLine();

            if (input.length() % 2 == 1) continue;
            if(isGoodWord(input)) answer++;
        }

        System.out.println(answer);
    }

    static boolean isGoodWord(String word) {
        for (int k = 0; k < word.length(); k++) {
            char cur = word.charAt(k);

            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                Character ex = stack.peek();

                if (ex.equals(cur)) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
        }

        return stack.isEmpty();
    }
}
