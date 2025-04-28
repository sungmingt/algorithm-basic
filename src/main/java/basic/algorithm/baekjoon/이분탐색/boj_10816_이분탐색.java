package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10816_이분탐색 {

    static int N, M;
    static int[] sangeun;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sangeun = new int[N];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sangeun[i] = Integer.parseInt(st.nextToken());
        }

        //sort
        Arrays.sort(sangeun);

        //input + search
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st.nextToken());

            //search
            //해당 숫자가 처음 등장하는 idx를 찾고, 거기서부터 해당 숫자가 안 나올때까지 탐색

            int lowerBound = getLowerBound(card);
            int upperBound = getUpperBound(card);

            sb.append(upperBound - lowerBound).append(" ");
        }

        System.out.println(sb);
    }

    //card가 나오는 첫번째 idx 구하기
    static int getLowerBound(int card) {
        int start = 0;
        int end = sangeun.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (sangeun[mid] >= card) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    //card보다 큰 수가 나오는 첫번째 idx 구하기
    static int getUpperBound(int card) {
        int start = 0;
        int end = sangeun.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (sangeun[mid] > card) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
