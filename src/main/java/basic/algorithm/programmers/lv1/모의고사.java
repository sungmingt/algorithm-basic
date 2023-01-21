package basic.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstAnswerCount = 0;
        int secondAnswerCount = 0;
        int thirdAnswerCount = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[(i % first.length)]) firstAnswerCount++;
            if (answers[i] == second[(i % second.length)]) secondAnswerCount++;
            if (answers[i] == third[(i % third.length)]) thirdAnswerCount++;
        }

        int max = Math.max(Math.max(firstAnswerCount, secondAnswerCount), thirdAnswerCount);

        List<Integer> list = new ArrayList<>();
        if(firstAnswerCount == max) list.add(1);
        if(secondAnswerCount == max) list.add(2);
        if(thirdAnswerCount == max) list.add(3);

        return list.stream().mapToInt(int.class::cast).toArray();
    }
}
