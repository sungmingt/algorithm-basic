package basic.algorithm.baekjoon.dfs;

import java.util.*;

public class 알고리즘수업_24479_dfs {

    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static Map<Integer, Integer> result;
    static int visitOrder;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        result = new HashMap<>(N + 1);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //간선 입력
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        //오름차순 방문 -> 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        visited[R] = true;
        visitOrder = 1;
        result.put(R, visitOrder);
        dfs24479(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(result.getOrDefault(i, 0));
        }
    }

    static void dfs24479(int startVertex) {
        //오름차순 방문
        for (int i = 0; i < graph.get(startVertex).size(); i++) {
            Integer newVertex = graph.get(startVertex).get(i);

            //방문하지 않았다면
            if (!visited[newVertex]) {
                visited[newVertex] = true;
                visitOrder++;
                result.put(newVertex, visitOrder);
                dfs24479(newVertex);
            }
        }
    }




//    static List<ArrayList<Integer>> graph;
//    static int[] checked;
//    static int visitOrder; //방문 순서
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int vertex = sc.nextInt();  //정점
//        int edge = sc.nextInt();    //간선
//        int startVertex = sc.nextInt();  //시작 정점
//
//        graph = new ArrayList<>();
//        checked = new int[vertex + 1];
//
//        for (int i = 0; i < vertex + 1; i++) {
//            graph.add(new ArrayList());
//        }
//
//        // {[1, 2], [2, 3] ...}
//
//        for (int i = 0; i < edge; i++) {
//            int fromVertex = sc.nextInt();
//            int toVertex = sc.nextInt();
//
//            graph.get(fromVertex).add(toVertex);
//            graph.get(toVertex).add(fromVertex);
//        }
//
//        //오름차순으로 방문해야 하기 때문에 정렬
//        for (int i = 1; i < graph.size(); i++) {
//            Collections.sort(graph.get(i));
//        }
//
//        visitOrder = 1;  //시작 정점도 방문 순서에 포함
//
//        dfs(startVertex);
//
//        for (int i = 1; i < checked.length; i++) {
//            System.out.println(checked[i]);
//        }
//    }
//
//    static void dfs(int vertex) {
//        checked[vertex] = visitOrder;
//
//        for (int i = 0; i < graph.get(vertex).size(); i++) {
//            int newVertex = graph.get(vertex).get(i);
//
//            if(checked[newVertex] == 0){ //방문 안 했을 경우
//                visitOrder++;
//                dfs(newVertex);
//            }
//        }
//    }
}
