package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_10845_deque {

    static Deque<Integer> q = new LinkedList<>();
    static int N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int input = Integer.parseInt(st.nextToken());
                q.offer(input);
                continue;
            } else if (cmd.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.poll());
            } else if (cmd.equals("size")) {
                sb.append(q.size());
            } else if (cmd.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0);
            } else if (cmd.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peekFirst());
            } else if (cmd.equals("back")) {
                sb.append(q.isEmpty() ? -1 : q.peekLast());
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
