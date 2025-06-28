package basic.algorithm.baekjoon.bruteForce.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1535_bruteForce {

    static int N;
    static int[] loss;
    static int[] gain;
    static int[][] lossAndGain;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        loss = new int[N];
        gain = new int[N];
        lossAndGain = new int[N][2];

        //input loss
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lossAndGain[i][0] = Integer.parseInt(st.nextToken());
        }

        //input gain
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lossAndGain[i][1] = Integer.parseInt(st.nextToken());
        }

        //1~N
        //loss의 합이 100 미만이 되는 한에서, 얻을 수 있는 최대 gain의 합 구하기
        //기쁨 오름차순 정렬
        //경우의 수는 2가지이다.
        //  -> 현재 요소를 선택하거나 or 선택하지 않거나
        //재귀로 구현

        //sort
        Arrays.sort(lossAndGain, Comparator.comparingInt(o -> o[1]));

        recur(0, 0, 0);
        System.out.println(max);
    }


    static void recur(int idx, int totalLoss, int totalGain) {
        if (idx >= N) {
            max = Math.max(max, totalGain);
            return;
        }

        int loss = lossAndGain[idx][0];
        int gain = lossAndGain[idx][1];

        //선택하지 못하는 경우
        if (totalLoss + loss >= 100) {
            recur(idx + 1, totalLoss, totalGain);
        } else { //선택할 수 있는 경우
            //선택 o
            recur(idx + 1, totalLoss + loss, totalGain + gain);
            //선택 x
            recur(idx + 1, totalLoss, totalGain);
        }
    }
}
