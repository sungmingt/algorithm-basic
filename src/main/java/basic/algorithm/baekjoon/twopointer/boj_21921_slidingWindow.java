package basic.algorithm.baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_21921_slidingWindow {

    static int N, X;
    static int[] visitors;
    static int maxVisitors;
    static int prevVisitors;
    static int period;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visitors = new int[N];

        //input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
            if (i < X) maxVisitors += visitors[i];
        }

        int lo = 0;
        int hi = X - 1;
        prevVisitors = maxVisitors;
        period = 1;

        //sliding window
        while (hi < visitors.length - 1) {
            lo++;
            hi++;

            int curVisitors = prevVisitors - visitors[lo - 1] + visitors[hi];

            //최대 구간보다 더 크다면
            if (curVisitors > maxVisitors) {
                maxVisitors = curVisitors;
                period = 1;
            }else if (curVisitors == maxVisitors) {
                period++;
            }

            prevVisitors = curVisitors;
        }

        System.out.println(maxVisitors == 0 ? "SAD" : maxVisitors + "\n" + period);
    }
}
