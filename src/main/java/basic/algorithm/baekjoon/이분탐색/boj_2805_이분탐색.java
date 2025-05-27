package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805_이분탐색 {

    static int N, M;
    static int[] trees;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        //가져갈수 있는 나무의 길이  :  trees[i] - H
        //적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값

        long maxHeight = 0;

        //input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        //sort (나무의 길이 <= H 인 경우 더이상 탐색하지 않도록)
        Arrays.sort(trees);

        long lo = 0;
        long hi = maxHeight;

        //H의 최댓값 구하기
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            long sum = getSum(mid);

            //조건을 충족한다면
            if (sum >= M) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static long getSum(long stdHeight) {
        long sum = 0;

        for (int i = trees.length - 1; i >= 0; i--) {
            if (trees[i] <= stdHeight) {
                break;
            }

            sum += trees[i] - stdHeight;
        }

        return sum;
    }
}
