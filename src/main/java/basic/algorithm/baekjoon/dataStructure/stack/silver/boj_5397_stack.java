package basic.algorithm.baekjoon.dataStructure.stack.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_5397_stack {

    static int N;
    static Stack<String> left;
    static Stack<String> right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] input = br.readLine().split("");
            left = new Stack<>();
            right = new Stack<>();
            //0 1 2 | 2 1 3

            for (String c : input) {

                if (c.equals("<")) {
                    toLeft();
                } else if (c.equals(">")) {
                    toRight();
                } else if (c.equals("-")) {
                    backSpace();
                } else {
                    print(c);
                }
            }

            StringBuilder password = new StringBuilder();

            while (!left.isEmpty()) password.append(left.pop());
            password.reverse();
            while (!right.isEmpty()) password.append(right.pop());

            System.out.println(password);
        }
    }

    private static void print(String c) {
        left.push(c);
    }

    private static void backSpace() {
        if (!left.isEmpty()) {
            left.pop();
        }
    }

    private static void toRight() {
        if (!right.isEmpty()) {
            left.push(right.pop());
        }
    }

    private static void toLeft() {
        if (!left.isEmpty()) {
            right.push(left.pop());
        }
    }
}
