package basic.algorithm.baekjoon.dataStructure.queue;

import java.io.*;
import java.util.*;

public class boj_1966_queue {

    static int[] importance;
    static int T, N, M;
    static int order;
    static Queue<Document> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        //중요도와 그 개수를 배열에 저장한다. ex)중요도 2인 문서의 개수 = importance[2]
        //문서를 꺼낼때마다 해당 중요도보다 높은 문서가 있는지 확인하고, 문서를 꺼내면 해당 배열의 개수를 차감한다.

        while (T-- > 0) {
            q = new LinkedList<>();
            importance = new int[10];
            order = 1;

            //input
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            //input importances
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int imp = Integer.parseInt(st.nextToken());
                q.offer(new Document(i, imp));
                importance[imp]++;
            }

            //문서 인쇄
            while (!q.isEmpty()) {
                //idx가 M인 문서가 인쇄되는 차례(order)를 출력.

                Document cur = q.poll();
                boolean isBiggerExists = false;

                for (int i = cur.importance + 1; i <= 9; i++) {
                    if (importance[i] > 0) {
                        isBiggerExists = true;
                        break;
                    }
                }

                if (isBiggerExists) {
                    q.offer(cur);
                } else {
                    if (cur.idx == M) {
                        break;
                    }

                    importance[cur.importance]--;
                    order++;
                }
            }

            System.out.println(order);
        }
    }

    private static class Document{
        int idx, importance;

        Document(int idx, int importance) {
            this.idx = idx;
            this.importance = importance;
        }
    }
}
