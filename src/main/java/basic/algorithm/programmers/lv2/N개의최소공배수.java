package basic.algorithm.programmers.lv2;

import java.util.Arrays;

public class N개의최소공배수 {

    static int solution(int[] arr) {
        //가장 큰 값을 순차적으로 곱한 값이 각 요소들의 공배수인지 확인한다.
        Arrays.sort(arr);
        int standard = arr[arr.length - 1];
        int currentValue = standard;

        while (true) {
            boolean isTrue = true;

            for (int i = 0; i < arr.length - 1; i++) {
                if (currentValue % arr[i] != 0) { //공배수가 아니면 바로 다음 숫자로 넘어간다.
                    isTrue = false;
                    break;
                }
            }

            if (isTrue) return currentValue;
            currentValue += standard;
        }
    }
}
