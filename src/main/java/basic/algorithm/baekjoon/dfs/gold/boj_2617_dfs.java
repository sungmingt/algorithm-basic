package basic.algorithm.baekjoon.dfs.gold;

import java.io.*;
import java.util.*;

public class boj_2617_dfs {

    static int N, M;
    static int[] lighter;
    static int[] heavier;
    static boolean[] visited;
    static List<ArrayList<Integer>> lightGraph;
    static List<ArrayList<Integer>> heavyGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        lighter = new int[N + 1];
        heavier = new int[N + 1];

        //그래프로 풀기
        //양방향? x, -> 단방향 두개(가벼운,무거운)

        //init graph
        lightGraph = new ArrayList<>();
        heavyGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            lightGraph.add(new ArrayList<>());
            heavyGraph.add(new ArrayList<>());
        }

        //input comparisons
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lightGraph.get(from).add(to);
            heavyGraph.get(to).add(from);
        }

        //2 1 -> 2번이 1번보다 무겁다.
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfsLighter(i, i);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfsHeavier(i, i);
        }

        int std = N / 2;
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (lighter[i] > std || heavier[i] > std) answer++;
        }

        System.out.println(answer);
    }

    private static void dfsHeavier(int start, int vertex) {
        for (int i = 0; i < heavyGraph.get(vertex).size(); i++) {
            Integer next = heavyGraph.get(vertex).get(i);
            if (!visited[next]) {
                visited[next] = true;
                heavier[start]++;
                dfsHeavier(start, next);
            }
        }
    }

    private static void dfsLighter(int start, int vertex) {
        for (int i = 0; i < lightGraph.get(vertex).size(); i++) {
            Integer next = lightGraph.get(vertex).get(i);
            if (!visited[next]) {
                visited[next] = true;
                lighter[start]++;
                dfsLighter(start, next);
            }
        }
    }
}
