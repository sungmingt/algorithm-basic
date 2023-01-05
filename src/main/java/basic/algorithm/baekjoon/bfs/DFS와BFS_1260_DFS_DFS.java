package basic.algorithm.baekjoon.bfs;

import java.util.*;

public class DFS와BFS_1260_DFS_DFS {

    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> dfsOrder;
    static ArrayList<Integer> bfsOrder;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int initialVertex = sc.nextInt();

        graph = new ArrayList<>();

        //graph 초기화
        for (int i = 0; i < vertexCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //graph 요소 채우기
        for (int i = 0; i < edgeCount; i++) {
            int fromVertex = sc.nextInt();
            int toVertex = sc.nextInt();

            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        //오름차순 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfsOrder = new ArrayList<>();
        dfsOrder.add(initialVertex);

        bfsOrder = new ArrayList<>();
        bfsOrder.add(initialVertex);

        dfs(initialVertex);
        bfs(initialVertex);

        for (Integer vertex : dfsOrder) {
            System.out.print(vertex + " ");
        }

        System.out.println();

        for (Integer vertex : bfsOrder) {
            System.out.print(vertex + " ");
        }
    }

    static void dfs(int vertex) {
        for (int i = 0; i < graph.get(vertex).size(); i++) {
            Integer nextVertex = graph.get(vertex).get(i);

            //방문 안했을 경우 방문
            if (!dfsOrder.contains(nextVertex)) { //contains 또는 배열 만들어 방문여부 따로 관리
                dfsOrder.add(nextVertex);
                dfs(nextVertex);
            }
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> q = new ArrayDeque();
        q.add(vertex);

        while (!q.isEmpty()) {
            Integer curVertex = q.poll();

            for (int i = 0; i < graph.get(curVertex).size(); i++) { //contains 또는 배열 만들어 방문여부 따로 관리
                Integer targetVertex = graph.get(curVertex).get(i);

                if (!bfsOrder.contains(targetVertex)) {
                    q.add(targetVertex);
                    bfsOrder.add(targetVertex);
                }
            }
        }
    }
}
