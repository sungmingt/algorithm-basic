package basic.algorithm.baekjoon.backtracking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 트럭_13335_Queue {

    static int N;
    static int W;
    static int L;
    static int[] trucks;
    static Queue<Integer> q;
    static int totalWeight;
    static int time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = sc.nextInt();
        L = sc.nextInt();

        trucks = new int[N];
        for (int i = 0; i < N; i++) {
            trucks[i] = sc.nextInt();
        }

        //다리에 W개의 트럭만 올라갈 수 있다
        //다리의 하중(L) >= 다리 위 트럭 무게의 합

        q = new LinkedList<>();
        for (int i = 0; i < trucks.length; i++) {
            int curTruck = trucks[i];

            while (true) {
                time++;

                if (totalWeight + curTruck <= L) {
                    q.offer(curTruck);
                    totalWeight += curTruck;
                    //다리 길이만큼 다 차면 맨 앞을 빼준다.
                    pollFirst(q);
                    break;
                } else {
                    q.offer(0);
                }

                //다리 길이만큼 다 차면 맨 앞을 빼준다.
                pollFirst(q);
            }
        }

        //마지막 요소 진입 후 break 한다 -> 다 빠져나올때까지 W만큼 걸리기 때문에 W를 더해준다.
        System.out.println(time + W);
    }

    static void pollFirst(Queue<Integer> q) {
        if (q.size() == W) {
            totalWeight -= q.poll();
        }
    }
}
