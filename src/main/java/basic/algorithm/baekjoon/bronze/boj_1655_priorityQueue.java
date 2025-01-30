package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj_1655_priorityQueue {

    static int N;
    static Queue<Integer> q1, q2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //작은 쪽에서는 항상 최대값을 다뤄야하기 때문에 내림차순으로 바꿔준다.
        q1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        q2 = new PriorityQueue<>();

        //q1의 길이가 q2의 길이보다 크거나 같아야 한다. + q1의 길이가 q2보다 큰 상태라면 q2에 값을 삽입한다.

        //input이 중간값보다 작다면 -> 길이 체크
        //  -> q1 > q2 이라면 -> q1의 최대값(중간값)을 q2에 삽입 + input을 q1에 삽입
        //  -> q1 <= q2 이라면 -> q1에 삽입
        //input이 중간값보다 크다면 -> 길이 체크
        //  -> q1 > q2 이라면 -> 그냥 input을 q2에 삽입
        //  -> q1 <= q2 이라면 -> q2의 최소값과 input 중 더 작은 값을 q1에 삽입 + 나머지를 q2에 삽입

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (q1.isEmpty()) {
                q1.offer(input);
                sb.append(q1.peek()).append("\n");
                continue;
            }

            Integer mid = q1.peek();

            if (input < mid) {
                //q1에 값을 삽입해야한다. 어차피 input < mid 이기 때문에 그냥 q1에 삽입하면 된다.
                if (q1.size() <= q2.size()) {
                    q1.offer(input);
                } else { //q2에 값을 삽입해야한다. input < mid 이기 때문에 mid를 q2로 옮겨준다.
                    q2.offer(q1.poll());
                    q1.offer(input);
                }
            } else {
                //q1에 값을 삽입해줘야 한다 -> q2의 최소값과 input 중 더 작은값을 q1으로 옮겨준다.
                if (q1.size() <= q2.size()) {
                    if (q2.peek() <= input) {
                        q1.offer(q2.poll());
                        q2.offer(input);
                    } else {
                        q1.offer(input);
                    }
                } else {
                    q2.offer(input);
                }
            }

            sb.append(q1.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
