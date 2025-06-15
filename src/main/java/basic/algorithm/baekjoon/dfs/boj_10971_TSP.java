package basic.algorithm.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10971_TSP {

    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < N; k++) {
                int cost = Integer.parseInt(st.nextToken());
                graph[i][k] = cost;
            }
        }

        //특정 도시에서 모든 도시(N개)를 순회하고 초기 도시로 돌아오는 최소 비용 구하기.
        //단방향 가중치
        //가중치 0은 자기 자신 또는 갈 수 없는 곳

        //search
        for (int i = 0; i < graph.length; i++) {
            visited = new boolean[N];
            search(i, i, 1, 0);
        }

        System.out.println(minCost);
    }

    private static void search(int start, int cityIdx, int depth, int totalCost) {
        //idx == start 일때 별도 처리
        if (cityIdx == start) {
            //depth == N+1 이면 -> 순회 완료
            if (depth == N + 1) {
                minCost = Math.min(minCost, totalCost);
            } else if (depth > 1) { //초기 탐색인 경우 제외, 다시 돌아왔을 경우 -> 탐색 못함
                return;
            }
        }

        for (int i = 0; i < graph[cityIdx].length; i++) {
            int nCost = graph[cityIdx][i];

            if (!visited[i] && nCost != 0) {
                visited[i] = true;
                search(start, i, depth + 1, totalCost + nCost);
                visited[i] = false;
            }
        }
    }
}
