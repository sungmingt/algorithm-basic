package basic.algorithm.baekjoon.bfs.gold;

import java.util.*;

public class 최단경로_1753_Dijkstra { //다익스트라 (다시 풀어보기)

    static int V, E, initialVertex;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        initialVertex = sc.nextInt();

        dist = new int[V + 1];
        graph = new ArrayList<>(V + 1);

        for (int i = 0; i <= V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //간선과 가중치 입력
        for (int i = 0; i < E; i++) {
            int fromVertex = sc.nextInt();
            int endVertex = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(fromVertex).add(new Node(endVertex, cost));
        }

        //최단거리 저장 배열 초기화
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        //우선순위 큐 사용 -> 효율성 증가
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        //시작 정점 최단거리 입력
        q.offer(new Node(initialVertex, 0));
        dist[initialVertex] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            //이동 조건
            //현재까지의 거리에 이동할 정점으로의 가중치를 더한 값 (dist[curNode.vertex] + newNode.cost)이
            //기존의 목표 정점으로의 최단 거리보다 짧아야 한다. ( < dist[newNode.vertex])

            for (int i = 0; i < graph.get(curNode.vertex).size(); i++) {
                Node newNode = graph.get(curNode.vertex).get(i);

                int newTotalCost = dist[curNode.vertex] + newNode.cost;
                int exTotalCost = dist[newNode.vertex];

                //최단거리일 경우 -> 최단거리 갱신 + 큐에 입력
                if (newTotalCost < exTotalCost) {
                    dist[newNode.vertex] = newTotalCost;
                    q.offer(new Node(newNode.vertex, dist[newNode.vertex]));
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
class Node{
    int vertex;
    int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}
