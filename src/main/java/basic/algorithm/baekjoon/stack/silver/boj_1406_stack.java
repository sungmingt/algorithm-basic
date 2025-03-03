package basic.algorithm.baekjoon.stack.silver;

import java.io.*;
import java.util.Stack;

public class boj_1406_stack {

    static Stack<Character> leftStr;
    static Stack<Character> rightStr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        leftStr = new Stack<>();
        rightStr = new Stack<>();
        char[] arr = br.readLine().toCharArray();

        //초기 커서는 마지막에 위치하므로 leftStr에 push
        for (int i = 0; i < arr.length; i++) {
            leftStr.push(arr[i]);
        }

        N = Integer.parseInt(br.readLine());

        //문자열의 길이가 4라면 [abcd]
        //cursor는 0 ~ 4
        //cursor : 1 -> 왼쪽은 a, 오른쪽은 bcd

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            String command = s[0];

            if (command.equals("L")) {
                if(!leftStr.isEmpty()) rightStr.push(leftStr.pop());
            } else if (command.equals("D")) {
                if (!rightStr.isEmpty()) leftStr.push(rightStr.pop());
            } else if (command.equals("B")) {
                //abcd - cursor:2
                //B 입력 -> str[1] 삭제 -> acd / cursor:1

                if(!leftStr.isEmpty()) leftStr.pop();
            } else if (command.equals("P")) {
                //abcd - cursor:2
                //P $ 입력 -> 2번쨰 자리에 $ 추기 -> ab$cd / cursor:3

                Character inputStr = s[1].charAt(0);
                leftStr.push(inputStr);
            }
        }

        while(!leftStr.isEmpty())
            rightStr.push(leftStr.pop());

        while(!rightStr.isEmpty())
            bw.write(rightStr.pop());

        bw.flush();
        bw.close();
    }
}
