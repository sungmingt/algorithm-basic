package basic.algorithm.baekjoon.greedy.silver;

import java.util.Scanner;

public class 주유소_13305_Greedy {

    static long[] distance;
    static long[] pricePerLiter;
    static long minPrice = Long.MAX_VALUE;
    static long minCost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityCount = sc.nextInt();

        pricePerLiter = new long[cityCount];
        distance = new long[cityCount - 1];

        //도시 거리 입력
        for (int i = 0; i < cityCount - 1; i++) {
            int dis = sc.nextInt();
            distance[i] = dis;
        }  //city[0] 에서 city[1] 까지의 거리는 distance[0] 이다.

        //리터당 가격 입력
        for (int i = 0; i < cityCount; i++) {
            pricePerLiter[i] = sc.nextInt();
        }

        //(pricePerLiter[i] >= minPrice) 이면 (minPrice * 이번 거리) 를 수행하여 total에 더한다.
        //(pricePerLiter[i] < minPrice) 이면 minPrice 초기화 후 (minPrice * 이번 거리)를 수행
        for (int i = 0; i < distance.length; i++) {
            if (pricePerLiter[i] < minPrice) {
                minPrice = pricePerLiter[i];
            }

            minCost += minPrice * distance[i];
        }

        System.out.println(minCost);
    }
}
