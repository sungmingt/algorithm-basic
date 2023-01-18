package basic.algorithm.programmers.lv2;

import java.util.HashSet;

public class 영어끝말잇기 {

    static int[] solution(int n, String[] words) {
        int curOrder = 1;
        int cycle = 1;
        HashSet<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (curOrder == n) { //for문 마지막일 경우 다시 처음으로
                curOrder = 1;
                cycle++;
            } else {
                curOrder++;
            }

            //사용했던 단어인 경우 / 1글자인 경우 / 끝말이 아닌 경우
            if (usedWords.contains(words[i]) || words[i].length() <= 1 || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return new int[]{curOrder, cycle};
            }

            usedWords.add(words[i]);
        }

        return new int[]{0, 0};
    }
}
