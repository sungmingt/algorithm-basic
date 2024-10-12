package basic.algorithm.baekjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실배정_1931_greedy {

    static int[][] schedule;
    static int count;
    static int prevFinishTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            schedule[i][0] = Integer.parseInt(s[0]);
            schedule[i][1] = Integer.parseInt(s[1]);
        }

        //1. 종료시간 기준 오름차순 정렬
        //2. 시작시간 기준 오름차순 정렬
        Arrays.sort(schedule, (o1, o2) -> o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0]);

        for (int k = 0; k < schedule.length; k++) {
            //회의 시작 시간이 앞선 회의 종료시간보다 크거나 같아야 한다.
            if (schedule[k][0] >= prevFinishTime) {
                count++;
                prevFinishTime = schedule[k][1];
            }
        }

        System.out.println(count);
    }
}
