package basic.algorithm.baekjoon.dijkstra;

import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class boj_10282_dijkstra {

    static int T, N, D, C;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
            D = Integer.parseInt(st.nextToken()); // 의존성 수
            C = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터

            //init graph
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Edge(a, s)); //b → a (감염 전파)
            }

            //해당 지점에서의 최단 감염 시간
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[C] = 0;

            //감염 시간 기준 최신순(오름차순) 정렬
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
            pq.offer(new Edge(C, 0));

            while (!pq.isEmpty()) {
                Edge now = pq.poll();

                //이미 더 빠르게 처리된 적 있다면 -> skip
                if (dist[now.to] < now.cost) continue;

                for (Edge next : graph.get(now.to)) {
                    if (dist[next.to] > dist[now.to] + next.cost) {
                        dist[next.to] = dist[now.to] + next.cost;
                        pq.offer(new Edge(next.to, dist[next.to]));
                    }
                }
            }

            int count = 0;
            int time = 0;
            for (int i = 1; i <= N; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    count++;
                    time = Math.max(time, dist[i]);
                }
            }

            sb.append(count).append(" ").append(time).append("\n");
        }

        System.out.print(sb);
    }

    private static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
