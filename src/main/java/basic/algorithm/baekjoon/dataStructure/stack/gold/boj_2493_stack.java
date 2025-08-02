package basic.algorithm.baekjoon.dataStructure.stack.gold;

import java.io.*;
import java.util.*;

public class boj_2493_stack {

    static int N;
    static int[] heights;
    static Stack<Tower> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int currentHeight = heights[i];

            //자신보다 낮은 탑 -> pop
            while (!stack.isEmpty() && stack.peek().height < currentHeight) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            //현재 탑을 스택에 push
            stack.push(new Tower(i + 1, currentHeight));
        }

        System.out.println(sb);
    }

    private static class Tower {
        int index;
        int height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

}
