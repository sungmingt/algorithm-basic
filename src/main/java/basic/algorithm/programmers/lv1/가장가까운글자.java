package basic.algorithm.programmers.lv1;

public class 가장가까운글자 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;

        for (int i = 1; i < s.length(); i++) {
            int result = -1;
            char current = s.charAt(i);

            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == current) {
                    result = i - j;
                    break;
                }
            }

            answer[i] = result;
        }

        return answer;
    }
}
