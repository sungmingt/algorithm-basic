package basic.algorithm.baekjoon.dataStructure.stack.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_12789_stack {

    static int N;
    static Stack<Integer> stack = new Stack<>();
    static int nextNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            //다음 순서의 번호표라면 -> 입장 처리
            if (num == nextNum) {
                nextNum++;

                //다음 입장 순서가 변경되었으니, stack의 대기열도 확인해야한다.
                checkWaitingRow();
            } else { //아니라면 -> stack(대기열)에 저장
                stack.push(num);
            }
        }

        if (stack.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }

    private static void checkWaitingRow() {
        //대기줄에 번호가 있다면
        if (!stack.isEmpty()) {
            //입장할 번호라면
            if (stack.peek() == nextNum) {
                stack.pop();
                nextNum++;
                checkWaitingRow();
            }
        }
    }
}
