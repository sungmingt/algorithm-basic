package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2512_이분탐색 {

    static int N;
    static int[] budgetRequests;
    static long maxStandard;
    static long maxBudget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budgetRequests = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long tempTotal = 0;
        for (int i = 0; i < N; i++) {
            budgetRequests[i] = Integer.parseInt(st.nextToken());
            tempTotal += budgetRequests[i];
        }

        maxBudget = Long.parseLong(br.readLine());

        //상한액을 구할 필요가 없다면 그대로 return
        if (tempTotal <= maxBudget) {
            Arrays.sort(budgetRequests);
            System.out.println(budgetRequests[budgetRequests.length - 1]);
            return;
        }

        //case 합 <= 예산
            // -> 예산요청값 중 최대값 그대로 출력
        //case 합 > 예산
            // 상한액을 구한다.
            // 최대 상한액을 구하고, 출력한다.

        //120 110 140 150 -> 520
        //485
        //35 부족

        //상한액 기준점을 잡고 이분탐색..?
        //상한액의 최대값은 maxBudget, 최소값은 maxBudget / N이다.
        //따라서 이분탐색 첫 기준점은 (maxBudget + (maxBudget / N)) / 2

        long start = maxBudget / N;
        long end = maxBudget;
        maxStandard = maxBudget / N;

        while (start <= end) {
            long standard = (start + end) / 2;
            int totalCosts = 0;

            //상한액이 충족되는지 계산
            for (int i = 0; i < budgetRequests.length; i++) {
                totalCosts += Math.min(budgetRequests[i], standard);
            }

            //충족된다면 -> 여기서 끝이 아니라, 상한액을 더 늘려가면서 최대값을 찾아내야한다.
            if (totalCosts < maxBudget) {
                start = standard + 1;
                maxStandard = standard;
            } else if (totalCosts > maxBudget) {
                end = standard - 1;
            } else {
                maxStandard = standard;
                break;
            }
        }

        System.out.println(maxStandard);
    }
}
