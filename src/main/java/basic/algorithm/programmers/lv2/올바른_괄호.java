package basic.algorithm.programmers.lv2;

import java.util.Stack;

public class 올바른_괄호 { //stack 문제

    //stack 사용
    boolean solution(String s) {
        String[] arr = s.split("");
        if(arr[0].equals(")") || arr[arr.length-1].equals("(")) return false;

        Stack<String> stack = new Stack();
        for (String str : arr) {
            if(str.equals("(")) stack.push(str);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    //stack 미사용
    boolean solution1(String s) {
        String[] arr = s.split("");
        if (arr[0].equals(")") || arr[arr.length - 1].equals("(")) return false;

        int closed = 0;
        for (String c : arr) {
            closed += c.equals(")") ? 1 : -1;
            if (closed >= 1) return false;
        }

        return closed == 0;
    }
}
