package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2980_simulation {

    static int signalCount, roadLength;
    static int curTime, curLocation;
    static Queue<Signal> signalQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        signalCount = Integer.parseInt(input[0]);
        roadLength = Integer.parseInt(input[1]);

        for (int i = 0; i < signalCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int signalLocation = Integer.parseInt(st.nextToken());
            int redTTL = Integer.parseInt(st.nextToken());
            int greenTTL = Integer.parseInt(st.nextToken());

            Signal signal = new Signal(signalLocation, redTTL, greenTTL);
            signalQueue.offer(signal);
        }

        //시작 시에는 빨간불
        //1초에 1미터 이동
        //도로 끝까지 이동하는데 걸리는 시간 구하기

        //접근
        //while문을 통해 1초마다 1미터씩 이동하고, 큐에 보관한 신호등을 꺼내보며 신호등에 도달하는지 체크한다.
        //신호등이 있는 위치에 도달할 경우, 현재 신호등의 신호가 무엇인지 계산한다.
        //계산법 -> if(curTime % (redTTL + greenTTL) < redTTL) -> 빨간불
        //빨간불일 경우, 현재 시간에 빨간불이 남은 시간을 더해준다.

        while (curLocation < roadLength) {
            curTime++;
            curLocation++;

            if (!signalQueue.isEmpty()) {
                Signal s = signalQueue.peek();

                //현재 위치에 신호등이 있을 경우
                if (s.signalLocation == curLocation) {
                    signalQueue.poll();

                    //빨간불일 경우
                    if (curTime % (s.redTTL + s.greenTTL) < s.redTTL) {
                        curTime += s.redTTL - (curTime % (s.redTTL + s.greenTTL));
                    }
                }
            }
        }

        System.out.println(curTime);
    }

    static class Signal {
        int signalLocation;
        int redTTL;
        int greenTTL;

        Signal (int signalLocation, int redTTL, int greenTTL) {
            this.signalLocation = signalLocation;
            this.redTTL = redTTL;
            this.greenTTL = greenTTL;
        }
    }
}
