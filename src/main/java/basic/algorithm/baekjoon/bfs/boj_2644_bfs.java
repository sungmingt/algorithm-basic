package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2644_bfs {

    static Queue<Integer> q;
    static int[] visited;
    static List<ArrayList<Integer>> graph;
    static int V, E;
    static int parent, child;
    static int answer = -1;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        //촌수계산, 두 사람의 촌수 계산 (관계가 없으면 -1 출력)
        //숫자 두개가 주어지고, 앞번호가 뒷번호의 부모
        //ex) 7 3 -> 7은 3의 부모 -> 양방향 그래프 연결

        //bfs로 탐색한다 -> target에 방문하면 종료
        //촌수를 계산하기 위해 visitied[]에 1씩 더하며 반복

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        visited = new int[V + 1];
        q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        parent = Integer.parseInt(st.nextToken());
        child = Integer.parseInt(st.nextToken());

        //init graph
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        E = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        bfs(parent);
        System.out.println(answer);
    }

    static void bfs(int parent) {
        q.offer(parent);
        visited[parent] = 1;

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                Integer next = graph.get(cur).get(i);

                //도달할경우
                if (next == child) {
                    answer = visited[cur];
                    return;
                }

                if (visited[next] == 0) {
                    q.offer(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }
    }
}
