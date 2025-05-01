package basic.algorithm.baekjoon.이분탐색.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110_이분탐색 {

    static int N, C;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];

        //input
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        //sort
        Arrays.sort(houses);

        if(C == 2) {
            System.out.println(houses[houses.length - 1] - houses[0]);
            return;
        }

        int lo = 1;
        int hi = houses[houses.length - 1] - houses[0];
        int result = 0;

        //이분 탐색의 목적 : 정확한 값(최대거리) 찾기
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (canInstall(mid)) {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(result);

    }

    static boolean canInstall(int distance) {
        int count = 1;
        int lastInstalled = houses[0];

        for (int i = 1; i < N; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i];
            }
        }

        return count >= C;
    }
}
