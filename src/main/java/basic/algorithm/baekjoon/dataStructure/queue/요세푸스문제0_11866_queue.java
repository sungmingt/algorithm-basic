package basic.algorithm.baekjoon.dataStructure.queue;

import java.util.LinkedList;
import java.util.Scanner;

public class 요세푸스문제0_11866_queue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrLength = sc.nextInt();
        int targetIndex = sc.nextInt();

        LinkedList<Integer> list = new LinkedList();
        for (int i = 1; i <= arrLength; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < arrLength; i++) {
            for (int k = 0; k < targetIndex - 1; k++) {
                list.offer(list.poll());
            }

            Integer poll = list.poll();

            if (i == 0) sb.append(poll);
            else sb.append(", " + poll);
        }

        sb.append(">");
        System.out.println(sb);
    }
    //[1, 2, '3', 4, 5, 6, 7]
    //[4, 5, '6', 7, 1, 2]
    //[7, 1, '2', 4, 5]
    //[4, 5, '7', 1]
    //[1, 4 '5']
    //[1, 4]
    //[4]
}
