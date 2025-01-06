package basic.algorithm.programmers.lv2.queue;

import java.util.LinkedList;
import java.util.Queue;

public class lv2_다리를지나는트럭_queue {
    //https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int curTime = 0;
        int curWeight = 0;
        int truckNum = 0;
        Queue<TruckInfo> q = new LinkedList<>();

        //현재 트럭의 위치를 어디에 저장할지, -> 트럭의 위치에 따라 언제 도착할지 결정하게 되기 때문에
        //예를 들어, 다음과 같을경우 [truck1 x x truck2]
        // -> 차량이 들어간 시간 정보를 저장한다.

        while (truckNum < truck_weights.length) {
            curTime++;

            //선두 트럭이 도착하는 경우
            // -> 현재 시간 - 트럭의 출발 시간 == bridge_length 이면 도착한것이다.
            if (!q.isEmpty()) {
                TruckInfo headTruck = q.peek();
                if (curTime - headTruck.enterTime == bridge_length) {
                    curWeight -= headTruck.weight;
                    q.poll();
                }
            }

            //트럭이 올라갈수 있으면 -> 올린다.
            if (q.size() + 1 <= bridge_length && curWeight + truck_weights[truckNum] <= weight) {
                q.offer(new TruckInfo(truck_weights[truckNum], curTime));
                curWeight += truck_weights[truckNum];
                truckNum++;
            }
        }

        //break 시점이 마지막 트럭이 다리에 오르는 시점이기 떄문에, 마지막 트럭이 도착하는 시간은 다리의 길이만큼 더 걸리기 때문에
        return curTime + bridge_length;
    }

    static class TruckInfo {
        int weight;
        int enterTime;

        TruckInfo(int weight, int enterTime) {
            this.weight = weight;
            this.enterTime = enterTime;
        }
    }
}
