package basic.algorithm.programmers.lv2;

import java.util.*;

public class 구명보트_Greedy {  //다시 풀어보기

    static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int minIndex = 0;
        int result = 0;

        for (int i = people.length - 1; minIndex <= i; i--) {
            if (people[i] + people[minIndex] <= limit) {
                minIndex++;
            }

            result++;
        }

        return result;
    }
}
