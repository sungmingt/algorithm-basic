package basic.algorithm.programmers.lv2;

import java.util.PriorityQueue;

public class 뒤에있는큰수찾기 { //다시 풀어보기 (자료구조 활용)

    public int[] solution(int[] numbers) {

        int[] answer = new int[numbers.length];
        answer[answer.length - 1] = -1;

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < numbers.length; i++) {
            int index = i;
            int value = numbers[i];

            //요소가 있을 경우
            if (!q.isEmpty()) {
                //현재 수보다 작은 수를 모두 처리할때까지 반복
                while (!q.isEmpty() && q.peek()[1] < value) {
                    int[] poll = q.poll();
                    answer[poll[0]] = value;
                }
            }

            q.offer(new int[]{index, value});
        }

        while (!q.isEmpty()) {
            answer[q.poll()[0]] = -1;
        }

        return answer;
    }
}
