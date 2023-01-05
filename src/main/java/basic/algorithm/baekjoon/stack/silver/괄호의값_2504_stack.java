package basic.algorithm.baekjoon.stack.silver;

import java.util.Scanner;
import java.util.Stack;

public class 괄호의값_2504_stack {

    public static void main(String[] args) {
        // (()[[]])([])
        //  ()[[]] 의 괄호값이 2 + 3×3=11 이므로 ‘(()[[]])’의 괄호값은 2×11=22 이다.
        // 그리고 ‘([])’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.
        Scanner sc = new Scanner(System.in);
        //괄호열
        String N = sc.nextLine();

        Stack<Character> stack = new Stack();
        int value = 1;
        int result = 0;

        //value =  1 2 4 2 6 18  6  2
        //result = 0 0 0 4 4  4 22 28
        for (int i = 0; i < N.length(); i++) {
            char K = N.charAt(i);

            // '(' 일 경우 value에 2를 곱한다.
            // '[' 일 경우 value에 3을 곱한다.
            if(K == '(') {
                value *= 2;
                stack.push(K);
            } else if (K == '[') {
                value *= 3;
                stack.push(K);
            }

            // ')' 일 경우 -> 바로 이전 값이 '(' 이면 value를 result에 더해주고, stack.pop으로 지워준다.
            //            -> 스택이 비었거나 이전에 '('이 없으면 -> result = 0 대입 후 반복문 탈출
            else if (K == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (N.charAt(i-1) == '('){
                    result += value;
                }
                stack.pop();
                value /= 2;
            }else if (K == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (N.charAt(i-1) == '['){
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        // 괄호짝이 남는 경우  -> 마지막이 '(' 또는 '[' 일 수 있기 때문에 마지막 예외 처리를 해줘야 한다.
        if(!stack.isEmpty()) result = 0;
        System.out.println(result);
    }
}
