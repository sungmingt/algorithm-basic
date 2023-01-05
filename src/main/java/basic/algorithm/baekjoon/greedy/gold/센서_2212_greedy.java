package basic.algorithm.baekjoon.greedy.gold;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 센서_2212_greedy { //문제 이해가 어려웠음.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //N : 센서 개수
        //K : 최대 집중국 개수
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] sensors = new int[N]; //센서들
        Integer[] margins = new Integer[N - 1]; //최소값을 구해야 한다 -> 센서간의 거리를 구해놓고, 차이가 가장 큰 것 부터 뺀다.

        int totalLength = 0; //센서 길이의 최대값
        int totalMargin = 0; //margin의 총합
        int result = 0;

        for (int i = 0; i < sensors.length; i++) {
            sensors[i] = sc.nextInt();
        }

        Arrays.sort(sensors);
        totalLength = sensors[sensors.length - 1] - sensors[0];

        for (int i = 0; i < sensors.length-1; i++) {
            margins[i] = sensors[i+1] - sensors[i];
        }

        Arrays.sort(margins, Collections.reverseOrder());

        int marginCount = K - 1;  //margin을 K-1 개만큼 뺄수 있음
        for (int i = 0; i < margins.length; i++) { //margin 구하기
            if(marginCount == 0) break; //뺄 수 있는 margin이 없다면
            totalMargin += margins[i];
            marginCount--;
        }

        result = totalLength - totalMargin;
        System.out.println(result);
    }
}
