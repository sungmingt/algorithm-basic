package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알고리즘수업2_24445_BFS {

    static Queue<Integer> q;
    static List<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int[] visitOrder;
    static int curVisitOrder;
    static int N, M, R;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        visitOrder = new int[N + 1];
        arr = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr.get(from).add(to);
            arr.get(to).add(from);
        }

        for (int i = 1; i < N + 1; i++) {
            arr.get(i).sort(Collections.reverseOrder());
        }

        //내림차순 정렬
        q = new LinkedList<>();
        q.add(R);
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (!visited[cur]) {
                visited[cur] = true;
                visitOrder[cur] = ++curVisitOrder;
                arr.get(cur).stream()
                        .filter(i -> !visited[i])
                        .forEach(i -> q.offer(i));
            }
        }

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visitOrder[i]);
        }
    }
}
