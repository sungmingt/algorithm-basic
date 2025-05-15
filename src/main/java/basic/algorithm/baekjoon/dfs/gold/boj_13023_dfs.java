package basic.algorithm.baekjoon.dfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_13023_dfs {

    static int N, M;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph;
    static boolean isExists;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        //graph init
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //graph input
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //중복되지 않는, 5명이 연결된 친구 관계가 존재하는지
        //  -> 깊이가 4인 경로가 존재하는지
        //dfs 탐색 -> depth:4 -> 정답

        for (int i = 1; i < N + 1; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;

            if (isExists) {
                answer = 1;
                break;
            }
        }

        System.out.println(answer);

        //1 7
        //3 7
        //4 7
        //3 4
        //4 6
        //3 5
        //0 4
        //2 7
        //  -> 2 7 3 4 6
    }

    static void dfs(int from, int depth) {
        if (depth == 4) {
            isExists = true;
            return;
        }

        for (int i = 0; i < graph.get(from).size(); i++) {
            Integer next = graph.get(from).get(i);

            //다음 노드 탐색
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}
