package basic.algorithm.programmers.lv2;

import java.util.Arrays;

public class 가장큰수_sort { //다시 풀어보기

    public String solution(int[] numbers) {
        //[4, 8, 21, 21, 2113]
        //842232221

        //String 배열로 이전
        String[] num = new String[numbers.length];
        for (int i = 0; i< numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(num, (o1, o2) -> {
            //두개 붙여서 비교 후 더 큰 경우를 선택
            return (Integer.parseInt(o2 + o1)) - Integer.parseInt(o1 + o2);
        });

        //{0, 0, 0, 0}의 경우 예외 처리
        if(num[0].equals("0")) return "0";

        String answer = "";
        for (String number : num) {
            answer += number;
        }

        return answer;
    }
}
