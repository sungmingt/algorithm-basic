package basic.algorithm.baekjoon.dfs;

import java.io.*;
import java.util.*;

public class boj_11724_graph {

    static int N, M;
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[N + 1];

        //init graph
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //input graph
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //연결 요소: 정점들을 순회하는 하나의 간선 루프 가 아니라, 그냥 경로로 연결되어 있으면 모두 하나의 연결 요소이다.

        //dfs
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int cur) {
        visited[cur] = true;

        for (int k = 0; k < graph.get(cur).size(); k++) {
            Integer next = graph.get(cur).get(k);

            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
