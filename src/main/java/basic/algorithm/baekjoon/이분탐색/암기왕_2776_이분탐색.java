package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 암기왕_2776_이분탐색 {

    static int[] note1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            note1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) note1[k] = Integer.parseInt(st.nextToken());
            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++){

                //이분 탐색
                int lo = 0;
                int hi = note1.length - 1;
                int value = Integer.parseInt(st.nextToken());
                boolean flag = false;

                // 1 2 3 4 5
                // 1 3 5 7 9
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;

                    //note1에 존재할 경우
                    if (note1[mid] == value) {
                        flag = true;
                        break;
                    }else if (note1[mid] < value) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }

                sb.append(flag ? 1 : 0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
