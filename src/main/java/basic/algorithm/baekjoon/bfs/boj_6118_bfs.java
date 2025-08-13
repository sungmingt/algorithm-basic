package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_6118_bfs {

    static int N, M;
    static List<Integer>[] graph;
    static Queue<Integer> q = new LinkedList<>();
    static int[] distance;
    static int maxDistance, count;
    static int number = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        distance = new int[N + 1];

        //init graph
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = -1;
        }

        //1에서 가장 거리가 먼 정점 중 번호가 가장 작은 것, 해당 거리, 같은 정점의 개수 찾기
        //bfs
        //1에서 시작해서 순회.
        //순회할때마다 +1

        //input edges
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        distance[1] = 0;
        q.offer(1);
        bfs();

        for (int i = 2; i < distance.length; i++) {
            if (distance[i] == maxDistance) {
                count++;
                number = Math.min(number, i);
            }
        }

        System.out.println(number + " " + maxDistance + " " + count);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i = 0; i < graph[cur].size(); i++) {
                Integer next = graph[cur].get(i);

                if (distance[next] != -1) {
                    continue;
                }

                distance[next] = distance[cur] + 1;
                maxDistance = Math.max(maxDistance, distance[next]);
                q.offer(next);
            }
        }
    }
}
