package basic.algorithm.programmers.lv1;

import java.util.Arrays;

public class 과일장수 {

    public int solution(int k, int m, int[] score) {
        //사과 점수 : 1~k
        //각 상자에 m개씩 담는다
        //각 상자의 가격 : 사과 중 가장 낮은 점수 * m
        //최대 이익 계산하기
        //남는 사과는 버린다.
        // -> 그냥 상자에 큰거부터 담는다. 그래야 최소값을 남길 수도 있다.
        int answer = 0;

        Arrays.sort(score);
        for (int i = score.length - 1; i - m >= -1; i -= m) {
            answer += m * score[i - m + 1];
        }

        return answer;
    }
}
