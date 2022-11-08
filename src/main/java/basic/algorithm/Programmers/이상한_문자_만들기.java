package basic.algorithm.Programmers;

public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        System.out.println("[" + solution("hello my name is jason ") + "]");
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String words = s.replace(" ", "_");
        int index = 0;

        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);

            //공백일 경우 띄어쓰기 + index 초기화
            if (c == '_') {
                index = 0;
                answer.append(" ");
                continue;
            }
            //index 짝수 or 0 -> 대문자 / 홀수 -> 소문자
            answer.append((index % 2 == 0) ? String.valueOf(c).toUpperCase() : String.valueOf(c).toLowerCase());
            index ++;
        }
        return answer.toString();
    }
}
