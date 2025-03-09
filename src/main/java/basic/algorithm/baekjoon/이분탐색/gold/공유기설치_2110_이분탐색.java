package basic.algorithm.baekjoon.이분탐색.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110_이분탐색 { //다시 풀어보기

    public static void main(String[] args) throws IOException {
        //N개의 집
        //C개의 공유기 설치
        //한 집에 하나만 설치 가능
        //가장 인접한 공유기 간의 거리의 최대값 구하기 -> Upper Bound

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //정렬
        Arrays.sort(arr);

        //가장 인접한 공유기 간의 거리의 최대값
        int max = arr[arr.length - 1];
        int min = 0;
        int mid = 0;

        //이분 탐색의 대상 값 : 가장 인접한 공유기 간의 거리
        //이분 탐색의 기준 : 공유기의 개수(C)
        while (min < max) {
            mid = (min + max) / 2;

            int installCount = 1;
            int prev = arr[0];

            for (int i = 1; i < arr.length; i++) {
                //이전 집과의 거리가 mid(목표하는 최소 거리)보다 크다면, 즉 이번 집에 공유기 설치가 가능하다면
                if (arr[i] - prev >= mid) {
                    prev = arr[i];
                    installCount++;
                }
            }

            //설치해야 하는 공유기 수보다 설치할 수 있는 공유기 수가 더 적다면 => 최소 거리를 줄인다.
            if (installCount < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
        //1 2  4     8 9
    }
}
