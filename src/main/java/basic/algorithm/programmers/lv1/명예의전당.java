package basic.algorithm.programmers.lv1;

import java.util.*;

public class 명예의전당 {

    public int[] solution(int k, int[] score) {
        Queue<Integer> q = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        //상위 k번째 이내이면 명예의전당 등극
        //초기 k일까지는 모든 가수가 오른다.
        //이후부터는 q.peek()와 비교해서 score[i]이 더 크면 q.poll + q.offer(value) + list.add(value)

        for (int i = 0; i < score.length; i++) {
            //k일까지는 자동 등극
            if (i < k) {
                q.offer(score[i]);
                list.add(q.peek());
            } else {
                if (score[i] > q.peek()) {
                    q.poll();
                    q.offer(score[i]);
                }

                list.add(q.peek());
            }
        }

        return list.stream().mapToInt(Integer::new).toArray();
    }
}
