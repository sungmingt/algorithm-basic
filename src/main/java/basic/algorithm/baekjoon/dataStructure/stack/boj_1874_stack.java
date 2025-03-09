package basic.algorithm.baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class boj_1874_stack {

    static int N;
    static int lastPushValue;
    static int[] arr;
    static List<String> operations;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        stack = new Stack<>();
        operations = new ArrayList<>();

        //input
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //1부터 N까지에 대해 push/pop 연산으로 해당 수열을 만들 수 있는지
        //가능 -> 연산을 순서대로 출력 (push:+ , pop:-)
        //불가능 -> NO 출력

        //단, push는 오름차순을 지켜야한다.
        //현재 pop 해야하는 값, 즉 수열의 현재값일때 pop 하면 된다.
        //8
        //4
        //3
        //6
        //8
        //7
        //5
        //2
        //1

        //여기서는 4가 나올때까지 먼저 push. 4일때 pop한다.
        //다음 수가 3. 따라서 현재 스택 LI 값이 3이니까 pop
        //다음 수가 6. 현재 스택 LI 값이 2이고, 4까지 넣었으니 5부터 다시 push

        for (int i = 0; i < arr.length; i++) {
            int popValue = arr[i];

            //pop 해야할 값이 스택에 이미 있을 경우
            if (popValue <= lastPushValue) {
                //현재 LI 값이 popValue일 경우에는 pop, 아니면 만들지 못한다.
                if (stack.peek() == popValue) {
                    stack.pop();
                    operations.add("-");
                } else {
                    System.out.println("NO");
                    return;
                }
            } else { //pop 해야할 값이 스택에 없는 경우 popValue까지 push 후 pop
                for (int k = lastPushValue + 1; k <= popValue; k++) {
                    stack.push(k);
                    operations.add("+");
                }

                lastPushValue = popValue;

                stack.pop();
                operations.add("-");
            }
        }

        operations.forEach(System.out::println);
    }
}
