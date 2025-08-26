package basic.algorithm.baekjoon.greedy.gold;

import java.io.*;
import java.util.*;

public class boj_14908_greedy {

    static int N;
    static Task[] tasks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tasks = new Task[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(i, time, fee);
        }

        //최저 보상금을 지불하는 작업 순서 구하기
        //미완료 작업 개수가 많더라도, 보상금이 작을수 있음

        //보상/시간 비율이 큰 순서로 정렬해야함
        //t1.time * t2.fee, t2.time * t1.fee 를 비교
        //각각 최종 보상의 크기이기 때문에, 왼쪽이 더 크다면 t2부터 작업을 진행해야함.

        Arrays.sort(tasks, (o1, o2) -> {
            long lhs = (long) o1.time * o2.fee; //o2의 최종 보상료
            long rhs = (long) o2.time * o1.fee; //o1의 최종 보상료

            if (lhs != rhs) return Long.compare(lhs, rhs);
            return Integer.compare(o1.idx, o2.idx);
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(tasks[i].idx + 1).append(" ");
        }

        System.out.println(sb);
    }

    private static class Task {
        int idx, time, fee;

        Task(int idx, int time, int fee) {
            this.idx = idx;
            this.time = time;
            this.fee = fee;
        }
    }
}
