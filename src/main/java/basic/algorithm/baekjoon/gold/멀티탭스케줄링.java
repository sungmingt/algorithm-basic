package basic.algorithm.baekjoon.gold;

import java.util.*;

public class 멀티탭스케줄링 {  //다시 풀어보기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int plugCount = sc.nextInt();
        int N = sc.nextInt();

        List<Integer> inUse = new ArrayList<>(); //현재 꽂혀있는 플러그를 담아둔다.
        int pullCount = 0;

        int[] usages = new int[N]; //일단 전기용품을 담아둔다.
        for (int i = 0; i < N; i++) {
            usages[i] = sc.nextInt();
        }

        for (int i = 0; i < usages.length; i++) {

            if (inUse.contains(usages[i])) { //현재 전기용품이 이미 꽂혀있다면, 아무것도 하지 않는다.
                continue;
            }else {

                if (inUse.size() < N) { //빈 플러그가 있다면
                    inUse.add(usages[i]);
                    continue;
                } else { //플러그가 꽉찼다면

                    for (int j = 0; j < inUse.size(); j++) { //최소로 사용되는 플러그를 구한다.
                    }

                }
            }

            // 2 3 2 3 1 2 2 1 3 2 7

            //2를 뺀다 -> 4
            //13  1
            //12  2
            //23  3
            //27  4

            //3을 뺀다 -> 3
            //12  1
            //23  2
            //27  3
            //플러그가 꽉 차있다면, 특정 플러그를 빼야한다.
            //이때, 나중에 덜 사용되는 플러그를 뺀다.
            //사용횟수가 같다면, 가장 늦게 사용되는 플러그를 뺀다.

        }


    }
}
