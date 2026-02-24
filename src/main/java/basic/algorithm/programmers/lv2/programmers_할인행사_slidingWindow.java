package basic.algorithm.programmers.lv2;
import java.util.*;

public class programmers_할인행사_slidingWindow {

    //https://school.programmers.co.kr/learn/courses/30/lessons/131127?language=java

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        //개수 세팅
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }

        //각 제품의 개수를 저장해야함.
        //특정 범위에서 각 제품의 개수를 모두 만족하는 경우에만 구매.

        //특정 범위 탐색 -> 슬라이딩 윈도우
        //1~10일 까지의 범위를 최초 탐색.
        //이후, 범위를 하나씩 옮겨가며 탐색.
        //map의 모든 요소가 0일 경우, 모두 살수 있음.

        //첫 10일 탐색
        for(int i=0; i<10; i++) {
            String product = discount[i];

            if(map.containsKey(product)) {
                int prevCount = map.get(product);
                map.put(product, prevCount - 1);
            }
        }

        if(check(map)) answer++;

        //이후 10일씩 탐색
        for(int i=10; i<discount.length; i++) {
            String next = discount[i];
            String prev = discount[i-10];

            if(map.containsKey(next)) {
                map.put(next, map.get(next) - 1);
            }

            if(map.containsKey(prev)) {
                map.put(prev, map.get(prev) + 1);
            }

            if(check(map)) answer++;
        }

        return answer;
    }

    public boolean check(Map<String, Integer> map) {
        for(int value : map.values()) {
            if(value != 0) return false;
        }

        return true;
    }
}
