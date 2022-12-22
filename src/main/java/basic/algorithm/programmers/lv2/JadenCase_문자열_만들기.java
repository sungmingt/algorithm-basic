package basic.algorithm.programmers.lv2;

public class JadenCase_문자열_만들기 {

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String words = s.toLowerCase();
        boolean isFirst = true;

        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            answer.append(isFirst ? String.valueOf(c).toUpperCase() : c);

            isFirst = c == ' ';
        }

        return answer.toString();
    }
}
