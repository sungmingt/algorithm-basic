package basic.algorithm.baekjoon.silver;

import java.util.LinkedList;
import java.util.Scanner;

public class 카드2_2164_queue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        LinkedList<Integer> list = new LinkedList();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            list.pop();
            Integer input = list.pop();
            list.add(input);
        }

        System.out.println(list.pop());
    }
}
