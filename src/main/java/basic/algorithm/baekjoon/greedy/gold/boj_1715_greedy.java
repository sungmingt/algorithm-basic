package basic.algorithm.baekjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_1715_greedy {

    static int N;
    static long totalCount;
    static PriorityQueue<Long> cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new PriorityQueue<>(Comparator.comparingLong(o -> o));

        //input
        for (int i = 0; i < N; i++) {
            long amount = Long.parseLong(br.readLine());
            cards.offer(amount);
        }


        while (cards.size() > 1) {
            Long fir = cards.poll();
            Long sec = cards.poll();
            long sum = fir + sec;

            totalCount += sum;
            cards.offer(fir + sec);
        }

        System.out.println(totalCount);
    }
}
