package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2512_이분탐색 {

    static int N;
    static int[] budgetRequests;
    static int maxStandard;
    static long totalBudget;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budgetRequests = new int[N];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgetRequests[i] = Integer.parseInt(st.nextToken());
            maxStandard = Math.max(maxStandard, budgetRequests[i]);
        }

        //이분 탐색의 대상 : 상한액
        //해당 상한액을 기준으로 예산을 짰을때, 예산보다 작거나 같은 최댓값을 구해야 한다.

        totalBudget = Long.parseLong(br.readLine());

        int lo = 0;
        int hi = maxStandard;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            long sum = getSum(mid);

            //예산 이내 값이라면
            if (sum <= totalBudget) {
                answer = mid;
                lo = mid + 1;
            } else { //예산보다 더 크다면
                hi = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static long getSum(int limit) {
        long sum = 0;

        for (int i = 0; i < budgetRequests.length; i++) {
            int budget = budgetRequests[i];

            //상한액보다 크다면
            if (budget > limit) {
                sum += limit;
            } else {
                sum += budget;
            }
        }

        return sum;
    }
}
