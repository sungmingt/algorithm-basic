package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_10866_deque {

    static Deque<Integer> q = new LinkedList<>();
    static int N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front":
                    value = Integer.parseInt(st.nextToken());
                    q.offerFirst(value);
                    break;
                case "push_back":
                    value = Integer.parseInt(st.nextToken());
                    q.offerLast(value);
                    break;
                case "pop_front":
                    sb.append(q.isEmpty() ? -1 : q.pollFirst());
                    sb.append("\n");
                    break;
                case "pop_back":
                    sb.append(q.isEmpty() ? -1 : q.pollLast());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size());
                    sb.append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0);
                    sb.append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst());
                    sb.append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast());
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
