package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920_이분탐색 {

    static int N, M;
    static StringTokenizer st;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }

        //sort
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            //이분 탐색 : start와 end를 변경해가며 해당 수가 존재하는지 찾는다? curIdx를 변경해가며 찾는다?

            int start = 0;
            int end = arr.length - 1;
            int mid = (start + end) / 2;
            boolean isContained = false;

            while (start <= end) {

                if (num == arr[mid]) {
                    isContained = true;
                    break;
                } else if (arr[mid] < num) {
                    start = mid + 1;
                    mid = (start + end) / 2;
                } else {
                    end = mid;
                    mid = (start + end) / 2;
                }
            }

            if(isContained) System.out.println(1);
            else System.out.println(0);

            //1 3 5 7 9
            //6
            //4
            //3
        }
    }
}
