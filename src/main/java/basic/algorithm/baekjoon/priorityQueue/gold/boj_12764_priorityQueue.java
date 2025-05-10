package basic.algorithm.baekjoon.priorityQueue.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_12764_priorityQueue {

    static int N;
    static int[][] times;
    static int[] computers;
    static Queue<int[]> usingSeats = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    static Queue<Integer> finishedSeats = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N][2];
        computers = new int[N];

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        //시작 시간 기준 오름차순 정렬
        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));

        //우선순위 큐에는 (컴퓨터 번호, 종료 시간) 을 저장.
        //각 루프마다 종료 시간이 지난 자리를 빈 자리 큐에 저장해준다.
        //종료된 자리가 없다면, 좌석 개수를 늘리고 해당 자리를 사용(사용 중인 자리 큐에 저장)

        //더 작은 자리 번호가 이미 비어있을 수도 있다.
        //자리번호 순 정렬 후 종료된 자리를 찾을따까지 순차 탐색? -> 비효율적임

        int seatNum = 0;

        for (int i = 0; i < N; i++) {
            int startTime = times[i][0];
            int endTime = times[i][1];

            //종료된 자리들의 번호를 finishedSeats에 추가해준다.
            saveEmptySeats(startTime);

            //빈 자리가 존재하는 경우
            if (!finishedSeats.isEmpty()) {
                Integer sn = finishedSeats.poll();
                computers[sn]++;
                usingSeats.offer(new int[]{sn, endTime});
            } else { //빈 자리가 없는 경우
                computers[seatNum]++;
                usingSeats.offer(new int[]{seatNum, endTime});
                seatNum++;
            }
        }

        //print
        StringBuilder sb = new StringBuilder();
        sb.append(seatNum).append("\n");

        for (int i = 0; i < seatNum; i++) {
            sb.append(computers[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void saveEmptySeats(int startTime) {
        while (!usingSeats.isEmpty()) {
            int[] seat = usingSeats.peek();

            if (startTime >= seat[1]) {
                int[] poll = usingSeats.poll();
                finishedSeats.add(poll[0]);
            } else {
                break;
            }
        }
    }
}
