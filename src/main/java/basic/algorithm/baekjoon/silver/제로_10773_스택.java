package basic.algorithm.baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class 제로_10773_스택 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();

            if (num == 0) { //0일 경우 최근에 나온 수를 모두 지운다. 문제에서 지울 요소가 있음을 보장한다.
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
