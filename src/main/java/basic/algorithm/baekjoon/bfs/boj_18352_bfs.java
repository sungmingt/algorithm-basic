package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18352_bfs {

    static int N, M, K, start;
    static List<ArrayList<Integer>> graph;
    static List<Integer> answer;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        answer = new ArrayList<>();
        distance = new int[N + 1];

        //init graph
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            distance[i] = -1;  // 아직 방문 안함
        }

        //input
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        //!!!! '최단거리'가 K여야 한다.

        //bfs
        bfs();

        StringBuilder sb = new StringBuilder();

        if (answer.isEmpty()) {
            sb.append(-1);
        } else {
            Collections.sort(answer);

            for (int a : answer) {
                sb.append(a).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            Integer curNode = q.poll();

            if (distance[curNode] == K + 1) break;

            for (int i = 0; i < graph.get(curNode).size(); i++) {
                Integer nextNode = graph.get(curNode).get(i);

                if (distance[nextNode] == -1) {
                    q.offer(nextNode);
                    distance[nextNode] = distance[curNode] + 1;

                    if (distance[nextNode] == K) {
                        answer.add(nextNode);
                    }
                }
            }
        }

        //K만큼 오지 않았는데 벌써 지나쳤다면 -> 최단거리가 K가 아님.
    }
}
