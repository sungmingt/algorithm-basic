package basic.algorithm.baekjoon.priorityQueue.silver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대힙_11279_priorityQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        list = new PriorityQueue<>((o1, o2) -> o2 - o1);

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
