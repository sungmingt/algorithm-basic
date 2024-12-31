package basic.algorithm.baekjoon.queue;

import java.io.*;
import java.util.*;

public class boj_11866_queue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                Integer poll = q.poll();
                q.offer(poll);
            }

            Integer rm = q.poll();
            answer.add(rm);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < answer.size(); i++) {
            if (i == answer.size() - 1) {
                sb.append(answer.get(i));
            } else {
                sb.append(answer.get(i)).append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
