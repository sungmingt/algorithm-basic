package basic.algorithm.programmers;

import java.util.Arrays;

public class 나누어_떨어지는_숫자배열 {

    public int[] solution(int[] arr, int divisor) {
        int[] filtered = Arrays.stream(arr).filter(num -> num % divisor == 0).sorted().toArray();
        return filtered.length == 0 ? new int[]{-1} : filtered;
    }
}
