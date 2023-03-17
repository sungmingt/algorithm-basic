package basic.algorithm.programmers.lv2;

import java.util.HashSet;

public class 연속부분수열합의개수_구현 {

    static HashSet<Integer> set;

    static int solution(int[] elements) {
        set = new HashSet<>();

        //i = 연속 수열의 개수 (1 ~ 4개)
        //j = 수열의 시작 index (0 ~ 4)
        //k = 수열의 index (0 ~ i)
        for (int i = 1; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                int tempJ = j;

                //지정된 수열의 개수(i)만큼 더한다.
                for (int k = 0; k < i; k++) {
                    sum += elements[tempJ + k];

                    //다음 요소가 배열 길이를 초과할 경우 -> 다음 요소(tempJ + k + 1)가 0으로 오도록 초기화 한다.
                    if (elements.length <= tempJ + k + 1) {
                        tempJ = -k - 1;
                    }
                }

                set.add(sum);
            }
        }

        return set.size() + 1;
    }
}
