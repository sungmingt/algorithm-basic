package basic.algorithm.programmers.lv2.greedy;

import java.util.*;

public class 호텔대실_Greedy {

    public int solution(String[][] book_time) {
        //최소 객실의 수
        //14     15     16    17   18    19    20    21     22
        //      ----------------
        //                40---------20
        //   20-----20
        //  10-----------------------------20
        //                           20-----------------20

        //빨리 시작하는 순으로 정렬 후, 빈 방이 있으면 사용, 없으면 새로운 방을 사용한다.
        Arrays.sort(book_time, (o1, o2) -> extractor(o1[1]) - extractor(o2[1]));
        //끝나는 시간을 오름차순으로 정렬
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);

        int minRoomCount = 1;
        for (int i = 0; i < book_time.length; i++) {
            int startTime = extractor(book_time[i][0]);
            int endTime = extractor(book_time[i][1]) + 10;

            //사용중인 방이 있으면
            if (!q.isEmpty()) {
                Integer earliestEndTime = q.peek();

                //남는 방이 없으면
                if (startTime < earliestEndTime) {
                    q.offer(endTime);
                    minRoomCount = q.size();
                } else {  //남는 방이 있으면
                    q.poll();
                    q.offer(endTime);
                }
            } else {
                q.offer(endTime);
            }
        }

        return minRoomCount;
    }

    public int extractor(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);

        return (hour * 60) + min;
    }
}
