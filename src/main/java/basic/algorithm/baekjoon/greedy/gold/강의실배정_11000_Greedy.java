package basic.algorithm.baekjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 강의실배정_11000_Greedy {

    static int N;
    static int[][] schedule;
    static Queue<Integer> q;
    static int maxRoomCount = 1;

    public static void main(String[] args) throws IOException {
        //강의실 사용이 시작되면 queue에 넣는다.
        //가장 먼저 종료되는 강의실을 가장 앞에 두어야 한다 -> 종료시간 기준 오름차순 정렬
        //다음 배열 요소(강의) 차례가 올때마다, queue의 가장 앞에 있는 강의의 종료 시간을 확인 후,
        // -> 종료되었으면 poll + add, 종료되지 않았으면 add + 강의실 최대 개수(maxRoom) ++

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        schedule = new int[N][2];
        q = new PriorityQueue<>(N, Comparator.comparingInt(o -> o));

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            schedule[i][0] = Integer.parseInt(s[0]);
            schedule[i][1] = Integer.parseInt(s[1]);
        }

        //시작시간 기준 오름차순 정렬
        Arrays.sort(schedule, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        for (int i = 0; i < schedule.length; i++) {
            //강의실을 사용할 수 있다면
            if (q.isEmpty() || schedule[i][0] >= q.peek()) {
                q.poll();
                q.offer(schedule[i][1]);
            } else {  //강의실을 사용할 수 없다면
                q.offer(schedule[i][1]);
                maxRoomCount = Math.max(q.size(), maxRoomCount);
            }
        }

        System.out.println(maxRoomCount);
    }
}

