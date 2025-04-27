package basic.algorithm.baekjoon.이분탐색.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10816 {

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

            int start = 0;
            int end = sangeun.length - 1;
            int mid = (start + end) / 2;
            int cnt = 0;

            while (start <= end) {
                if (sangeun[mid] == card) {
                    //첫번째 숫자일경우, 거기서부터 그냥 탐색
                    if (mid == 0 || sangeun[mid - 1] < card) {

                        //해당 숫자가 끝날때까지 탐색
                        int idx = mid;
                        while (idx < sangeun.length) {
                            if (sangeun[idx] == card) {
                                cnt++;
                                idx++;
                            } else {
                                break;
                            }
                        }

                        break;
                    } else {
                        end = mid;
                    }
                } else if (sangeun[mid] < card) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

                //10
                //-10 2 3 3 5 5      6 7 10 10 10
                //8
                //10 9 -5 2 3 4 5 -10

                mid = (start + end) / 2;
            }

            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }
}
