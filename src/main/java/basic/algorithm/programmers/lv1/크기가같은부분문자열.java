package basic.algorithm.programmers.lv1;

public class 크기가같은부분문자열 {

    public int solution(String t, String p) {
        int n = p.length();
        int answer = 0;

        int i = 0;
        while (i + n <= t.length()) {
            String number = t.substring(i, i + n);
            if (Long.parseLong(number) <= Long.parseLong(p)) {
                answer++;
            }

            i++;
        }

        return answer;
    }
}
