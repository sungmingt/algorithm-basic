package basic.algorithm.baekjoon.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 알고리즘수업_24479_dfs { //dfs 기본 (다시 풀어보기)

    static List<ArrayList<Integer>> graph;
    static int[] checked;
    static int visitOrder; //방문 순서

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();  //정점
        int edge = sc.nextInt();    //간선
        int startVertex = sc.nextInt();  //시작 정점

        graph = new ArrayList<>();
        checked = new int[vertex + 1];

        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList());
        }

        // {[1, 2], [2, 3] ...}

        for (int i = 0; i < edge; i++) {
            int fromVertex = sc.nextInt();
            int toVertex = sc.nextInt();

            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        //오름차순으로 방문해야 하기 때문에 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        visitOrder = 1;  //시작 정점도 방문 순서에 포함

        dfs(startVertex);

        for (int i = 1; i < checked.length; i++) {
            System.out.println(checked[i]);
        }

    }

    static void dfs(int vertex) {
        checked[vertex] = visitOrder;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);

            if(checked[newVertex] == 0){ //방문 안 했을 경우
                visitOrder++;
                dfs(newVertex);
            }
        }


    }
}
