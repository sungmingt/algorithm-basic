package basic.algorithm.programmers.lv1;

public class 문자열_내_p와y의개수_string {

    //https://school.programmers.co.kr/learn/courses/30/lessons/12916?language=java
    private static boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        char[] chars = s.toLowerCase().toCharArray();

        for (char c : chars) {
            if (c == 'p') {
                pCount++;
            } else if (c == 'y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}
