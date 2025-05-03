package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1654_이분탐색 {

    static int K, N;
    static long[] cables;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cables = new long[K];

        long lo = 1;
        long hi = 1;

        //input
        for (int i = 0; i < cables.length; i++) {
            cables[i] = Long.parseLong(br.readLine());
            hi = Math.max(hi, cables[i]);
        }

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            int cnt = 0;

            for (long len : cables) {
                cnt += len / mid;
            }

            if (cnt >= N) {
                answer = Math.max(answer, mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(answer);


        //다른 풀이
        // lo < hi
        // mid가 정답이 되지 않는 경우, hi = mid
        //  -> hi는 정답이 될수 없는 값이고, lo=hi 가 될 경우 lo,hi는 정답이 되지 않는 값이기 때문에 lo - 1이 정답이 된다.

//        while (lo < hi) {
//            long mid = (lo + hi) / 2;
//            long cnt = 0;
//
//            for (long cable : cables) {
//                cnt += cable / mid;
//            }
//
//            if (cnt >= N) {
//                lo = mid + 1;
//            } else {
//                hi = mid;
//            }
//        }
//
//        System.out.println(lo - 1);
    }
}
