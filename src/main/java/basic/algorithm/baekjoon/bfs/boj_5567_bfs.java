package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_5567_bfs {

    static int[] relation;
    static List<ArrayList<Integer>> graph;
    static int V, E;
    static int answer;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        //상근 : 1, 상근이의 친구의 친구까지만 초대 -> 거리가 2만큼 떨어진 노드까지만 탐색 -> bfs
        //relation <= 3인 경우까지만 탐색, relation > 3인 경우 탐색하지 않는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        relation = new int[V + 1];
        q = new LinkedList<>();
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        bfs(1);
        System.out.println(answer);
    }

    static void bfs(int person) {
        q.offer(person);
        relation[person] = 1;

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            if(relation[cur] >= 3) continue;

            for (int i = 0; i < graph.get(cur).size(); i++) {
                Integer next = graph.get(cur).get(i);

                if (relation[next] == 0) {
                    relation[next] = relation[cur] + 1;
                    q.offer(next);
                    answer++;
                }
            }
        }
    }
}
