package basic.algorithm.programmers.lv2;

import java.util.Arrays;

public class 가장큰수_sort {

    //https://school.programmers.co.kr/learn/courses/30/lessons/42746
    public String solution(int[] numbers) {
        //toString
        String[] num = new String[numbers.length];
        for (int i = 0; i< numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }

        //42 4 3
        //앞자리가 가장 큰 수를 앞에 놓는다.
        //앞자리가 같은 경우, 두번째 자리로 비교한다.
        //하지만, 각 자리수가 다르기때문에 첫째자리-둘째자리-셋째... 이렇게 비교하기 어렵다.

        //두개를 이어붙였을때, 더 큰 값이 되도록 (내림차순)
        Arrays.sort(num, (o1, o2) -> (Integer.parseInt(o2 + o1)) - Integer.parseInt(o1 + o2));

        //0만 존재하는 경우
        if(num[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();
        for (String n : num) {
            answer.append(n);
        }

        return answer.toString();
    }
}
