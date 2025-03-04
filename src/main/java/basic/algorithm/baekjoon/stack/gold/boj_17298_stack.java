package basic.algorithm.baekjoon.stack.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17298_stack {

    static int N;
    static int[] arr;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //배열을 순회한다.
        //이전 요소보다 작은 값일 경우 -> stack에 해당 idx를 push
        //이전 요소보다 큰 값일 경우 ->
        //  stack에서 idx를 차례로 peek 하면서 해당 배열 값(arr[idx])이 현재값보다 작다면 현재값(arr[i])으로 초기화시켜주고, pop
        //      (stack에 들어있으면서, 현재값보다 작으면 현재값이 오큰수가 되기 떄문)
        //  현재값보다 크다면 stop (어차피 이전의 요소들은 현재값보다 크기때문에 확인할 필요가 없다)
        //배열을 모두 순회한 후 stack에 여전히 남아있는 수는 오큰수가 없는 것이므로 -1로 초기화

        for (int i = 0; i < arr.length; i++) {
            //stack을 순회
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        //stack에 남아있는 값들은 오큰수가 없는 값의 인덱스이다 -> -1로 초기화
        while (!stack.isEmpty()) {
            Integer idx = stack.pop();
            arr[idx] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }

        System.out.println(sb);
    }
}
