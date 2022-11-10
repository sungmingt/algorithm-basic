package basic.algorithm.Programmers;

import java.util.Arrays;

public class 최댓값과_최솟값 {

    public String solution(String s) {
        String[] strs = s.split(" ");
        int[] numbers = Arrays.stream(strs).mapToInt(Integer::parseInt).sorted().toArray();

        int max = numbers[numbers.length - 1];
        int min = numbers[0];

        return min + " " + max;
    }
}
