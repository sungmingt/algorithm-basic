package basic.algorithm.baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_2346_deque {

    static int N;
    static Deque<Balloon> deq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int pointer = Integer.parseInt(st.nextToken());
            deq.offerLast(new Balloon(i, pointer));
        }

        //현재 값을 poll
        //poll 한 값의 idx를 sb에 append + val을 통해 targetIdx를 수정

        //5
        //3 2 1 -3 -1

        //poll : 1 3
        //val:양수 -> 현재 요소를 poll 한 후, val - 1 만큼 차례로 모두 마지막에 넣어준다.
        //deq : -3 -1 2 1
        //       4  5 2 3

        //poll : 4 -3
        //val:음수 -> 현재 요소를 poll 한 후, 마지막 요소부터 val 만큼 차례로 모두 처음에 넣어준다.
        // size : 3, val : -3
        //deq : -1 2 1
        //       5 2 3

        StringBuilder sb = new StringBuilder();

        while (!deq.isEmpty()) {
            //현재 풍선을 꺼내고, idx 출력
            Balloon balloon = deq.pollFirst();
            sb.append(balloon.idx).append(" ");

            if (deq.isEmpty()) {
                break;
            }

            if (balloon.pointer > 0) {
                for (int i = 0; i < balloon.pointer - 1; i++) {
                    deq.offerLast(deq.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(balloon.pointer); i++) {
                    deq.offerFirst(deq.pollLast());
                }
            }
        }

        System.out.println(sb);
    }

    static class Balloon {
        int idx;
        int pointer;

        Balloon(int idx, int pointer) {
            this.idx = idx;
            this.pointer = pointer;
        }
    }
}

