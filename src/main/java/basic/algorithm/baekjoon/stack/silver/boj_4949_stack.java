package basic.algorithm.baekjoon.stack.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_4949_stack {

    static Stack<String> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //')'가 입력될 경우 -> 이전 요소의 값이 '('여야 한다. ']'의 경우도 마찬가지.
        //괄호가 하나도 없는 경우에도 균형잡힌 문자열이다.

        while (true) {
            boolean isBalanced = true;
            stack = new Stack<>();
            String[] input = br.readLine().split("");

            if(input.length == 1 && input[0].equals(".")) return;

            for (int i = 0; i < input.length; i++) {
                String letter = input[i];

                if (letter.equals("(") || letter.equals("[")) {
                    stack.push(letter);
                } else if (letter.equals(")")) {
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        isBalanced = false;
                        break;
                    }else {
                        stack.pop();
                    }
                } else if (letter.equals("]")) {
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        isBalanced = false;
                        break;
                    }else {
                       stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) isBalanced = false;

            if(isBalanced) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
