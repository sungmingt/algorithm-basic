package basic.algorithm.programmers.lv2.stack;

import java.util.Stack;

public class 괄호회전하기_Stack {

    static int solution(String s) {
        //0 ~ s.length() - 1 만큼 회전 가능
        //회전한다 -> 첫 요소를 마지막 요소에 삽입

        Stack<Character> globalStack = new Stack<>();
        int answer = 0;
        char[] chars = s.toCharArray();

        //globalStack 초기화
        for (char c : chars) {
            globalStack.push(c);
        }

        for (int i = 0; i < chars.length; i++) {
            Stack<Character> localStack = new Stack<>();
            boolean isTrue = true;

            //올바른 괄호인지 확인
            for (char c : globalStack) {
                if (c == '[' || c == '(' || c == '{') {
                    localStack.push(c);
                } else if (c == ']') {
                    if (localStack.isEmpty() || localStack.peek() != '[') {
                        isTrue = false;
                        break;
                    } else {
                        localStack.pop();
                    }
                } else if (c == ')') {
                    if (localStack.isEmpty() || localStack.peek() != '(') {
                        isTrue = false;
                        break;
                    } else {
                        localStack.pop();
                    }
                } else if (c == '}') {
                    if (localStack.isEmpty() || localStack.peek() != '{') {
                        isTrue = false;
                        break;
                    } else {
                        localStack.pop();
                    }
                }
            }

            //스택에 괄호가 남아있거나 | 올바른 괄호가 아니라면
            if (!(!localStack.isEmpty() || !isTrue)) {
                answer++;
            }

            globalStack.push(globalStack.remove(0));
        }

        return answer;
    }
}
