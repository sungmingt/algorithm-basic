package basic.algorithm.programmers.lv1;

public class 문자열나누기 {

    public static int solution(String s) {
        int wordCount = 0;
        int firstCount = 0;
        int extraCount = 0;
        char first = ' ';

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                wordCount++;
                break;
            }

            if (firstCount == 0 && extraCount == 0) { //문자열 분해 후 첫 글자라면
                first = s.charAt(i);
                firstCount++;
            } else {
                if (s.charAt(i) == first) { //첫 글자와 같다면
                    firstCount++;
                } else {
                    extraCount++;
                }
            }

            if (firstCount == extraCount) { //첫 글자 개수와 나머지 개수가 같으면 문자열 분해(wordCount++)
                wordCount++;
                firstCount = 0;
                extraCount = 0;
            }
        }

        return wordCount;
    }
}
