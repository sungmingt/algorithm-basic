package basic.algorithm.programmers.lv2;

import java.util.*;

public class 기능개발_queue {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (Integer p : progresses) q.add(p);

        int totalTimeSpent = 0;
        while (!q.isEmpty()) {
            totalTimeSpent++;

            if (q.peek() + (totalTimeSpent * speeds[speeds.length - q.size()]) >= 100) {
                int deployedCount = 0;

                while (!q.isEmpty() && q.peek() + (totalTimeSpent * speeds[speeds.length - q.size()])>= 100) {
                    q.poll();
                    deployedCount++;
                }

                answer.add(deployedCount);
            }
        }

        return answer.stream().mapToInt(Integer::new).toArray();
    }
}
