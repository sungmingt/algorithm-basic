package basic.algorithm.baekjoon.stack.silver;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌세상_4949_stack {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();

        //괄호가 없어도 yes이다. 즉, 잘못된 괄호가 나왔을때에 no를 출력하면 된다.
        while (true) { // 온점(.)이 나오면 break
            String sentence = sc.nextLine();
            if(sentence.equals(".")) {
                break;
            }

            String result = "yes";
            for (int i = 0; i < sentence.length(); i++) {
                char letter = sentence.charAt(i);

                if (letter == '(' || letter == '[') {
                    stack.push(letter);
                } else if (letter == ')') {
                    if(stack.isEmpty()){
                        result = "no";
                        break;
                    }

                    if(stack.pop() != '(') {
                        result = "no";
                        break;
                    }
                } else if (letter == ']') {
                    if(stack.isEmpty()){
                        result = "no";
                        break;
                    }


                    if (stack.pop() != '[') {
                        result = "no";
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) { //'(' 또는 '['가 스택에 남아있을 수 있다.
                result = "no";
            }

            stack.clear();
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}
