package basic.algorithm.programmers.lv2.queue;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터_Queue {

    //(기존 index, 중요도)
    static Queue<int[]> q;

    public int solution(int[] priorities, int location) {
        //location : 인쇄 요청한 문서의 index
        //요청한 문서가 인쇄되는 순서를 출력

        //최초 인쇄 번호 : 1
        int answer = 1;
        q = new LinkedList<>();

        //queue 채우기
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }

        //인쇄하기
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            //중요도가 더 높은 문서가 있다면
            if (q.stream().anyMatch(s -> s[1] > poll[1])) {
                q.offer(poll);
            } else { //아니라면 인쇄한다.
                //요청한 문서라면 -> 정답 출력
                if (poll[0] == location) break;
                else answer++;
            }
        }

        return answer;
    }
}
