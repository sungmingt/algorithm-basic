package basic.algorithm.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1446_dijkstra {

    static int N, D;
    static int[][] shortCuts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        shortCuts = new int[N][3]; // [시작, 도착, 거리]

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shortCuts[i][0] = Integer.parseInt(st.nextToken());
            shortCuts[i][1] = Integer.parseInt(st.nextToken());
            shortCuts[i][2] = Integer.parseInt(st.nextToken());
        }

        // 그래프: 위치별 인접 노드 리스트 (to, cost)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        // 기본 도로 간선 추가 (i -> i+1, cost 1)
        for (int i = 0; i < D; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }

        // 지름길 추가 (to <= D && 지름길이 기존 거리보다 짧은 경우만)
        for (int i = 0; i < N; i++) {
            int from = shortCuts[i][0];
            int to = shortCuts[i][1];
            int dist = shortCuts[i][2];

            if (to <= D && dist < (to - from)) {
                graph.get(from).add(new int[]{to, dist});
            }
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0}); // {위치, 비용}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int cost = cur[1];

            if (dist[pos] < cost) continue;

            for (int[] next : graph.get(pos)) {
                int nextPos = next[0];
                int nextDist = next[1];

                if (dist[nextPos] > dist[pos] + nextDist) {
                    dist[nextPos] = dist[pos] + nextDist;
                    pq.offer(new int[]{nextPos, dist[nextPos]});
                }
            }
        }

        System.out.println(dist[D]);
    }
}
