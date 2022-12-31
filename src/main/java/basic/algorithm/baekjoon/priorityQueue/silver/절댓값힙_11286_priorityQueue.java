package basic.algorithm.baekjoon.priorityQueue.silver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 절댓값힙_11286_priorityQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        list = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) { //절댓값이 같을 경우 내림차순
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2); //절댓값 기준 내림차순 (기본이 내림차순)
            }
        });

        for (int i = 0; i < N; i++) {
            int command = sc.nextInt();

            if (command == 0) {
                System.out.println(getMax());
            } else {
                push(command);
            }
        }
    }

    static PriorityQueue<Integer> list;
    static void push(int x) {
        list.add(x);
    }
    static int getMax() {
        return list.isEmpty() ?  0 : list.poll();
    }
}
