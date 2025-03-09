package basic.algorithm.programmers.lv2.stack;

import java.util.Stack;

public class 짝지어제거하기_stack { //다시 풀어보기

    static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(cur);
            } else{
                if (cur == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
