package basic.algorithm.baekjoon.bfs;

import java.io.*;
import java.util.*;

public class boj_1058_graph {

    static int N;
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int maxFriendsCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        //init graph
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        //input
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");

            for (int k = 0; k < N; k++) {
                //직접 간선이 존재할 경우 -> 1로 초기화
                if (s[k].equals("Y")) {
                    graph.get(i).add(k);
                    graph.get(k).add(i);
                }
            }
        }

        //가장 유명한 사람 : 직접/간접 간선이 가장 많은 사람
        //각 정점마다 visited[] 관리
        //bfs 탐색

        Queue<Vertex> q = new LinkedList<>();

        //bfs
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            int friendsCnt = 0;

            q.offer(new Vertex(i, 0));

            while (!q.isEmpty()) {
                Vertex cur = q.poll();
                int idx = cur.idx;
                int depth = cur.depth;

                for (int k = 0; k < graph.get(idx).size(); k++) {
                    Integer next = graph.get(idx).get(k);

                    if (!visited[next]) {
                        visited[next] = true;
                        friendsCnt++;

                        //친구의 친구라면, 더이상 탐색하지 않는다.
                        if (depth < 1) {
                            q.offer(new Vertex(next, depth + 1));
                        }
                    }
                }
            }

            maxFriendsCnt = Math.max(maxFriendsCnt, friendsCnt);
        }

        System.out.println(maxFriendsCnt);
    }

    private static class Vertex {
        int idx, depth;

        Vertex(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
}
