package basic.algorithm.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2884_simulation {

    static int hour, minute;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);

        //minute < 45 일경우
        //  hour가 0이 아닐 경우 -> minute = 60 - (45 - minute);
        //  hour가 0일경우 -> minute은 똑같이 처리, hour = 23;
        //minute >= 45 일경우 -> 그냥 minute -= 45;

        if (minute < 45) {
            minute = 60 - (45 - minute);
            if (hour == 0) hour = 23;
            else hour--;
        } else {
            minute -= 45;
        }

        System.out.println(hour + " " + minute);
    }
}
