package basic.algorithm.baekjoon.dijkstra;

import java.util.*;

public class 숨바꼭질3_13549_Dijkstra {

    static int[] dist;
    static Queue<Node> q;
    static int N;
    static int K;
    static int INF = Integer.MAX_VALUE;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        dist = new int[10000 + 1];
        q = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        q.offer(new Node(N, 0));

        Arrays.fill(dist, INF);
        dist[N] = 0;

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int curIdx = curNode.idx;
            int curDistance = curNode.distance;

            //현재 거리가 이전의 최소거리보다 이미 크다면
            if (minDistance <= curDistance) {
                continue;
            }

            //목표지점 도착 시
            if (curIdx == K) {
                minDistance = Math.min(minDistance, curDistance);
                continue;
            }

            //앞으로 1 이동할 수 있으면
            if (curIdx + 1 < dist.length
                    && dist[curIdx] + 1 < dist[curIdx + 1]) {
                dist[curIdx + 1] = dist[curIdx] + 1;
                q.offer(new Node(curIdx + 1, dist[curIdx + 1]));
            }

            //앞으로 순간이동 할 수 있으면
            if (curIdx * 2 < dist.length
                    && dist[curIdx] < dist[curIdx * 2]) {
                dist[curIdx * 2] = dist[curIdx];
                q.offer(new Node(curIdx * 2, dist[curIdx * 2]));
            }
            //뒤로 1 이동할 수 있으면
            if (0 <= curIdx - 1
                    && dist[curIdx] + 1 < dist[curIdx - 1]) {
                dist[curIdx - 1] = dist[curIdx] + 1;
                q.offer(new Node(curIdx - 1, dist[curIdx - 1]));
            }
        }

        return minDistance;
    }

    static class Node{
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }
}
