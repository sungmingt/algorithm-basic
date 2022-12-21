package basic.algorithm.baekjoon.gold;

import java.util.Scanner;

public class 빗물_14719_simulation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        int result = 0;
        int[] heights = new int[W];

        for (int i = 0; i < W; i++) {
            heights[i] = sc.nextInt();
        }

        //물이 고일 수 있는 조건 : 특정 W의 양쪽의 높이가 커야함.
        //고이는 넓이 :  양쪽의 W중 최소 높이 - 가운데 W의 높이

        for (int i = 1; i < heights.length-1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            //현재 index에서 제일 왼쪽의 최대값과 오른쪽의 최대값 중 더 작은 값 - 현재

            //좌측 최대값
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, heights[j]);
            }

            //우측 최대값
            for (int j = i+1; j < heights.length; j++) {
                rightMax = Math.max(rightMax, heights[j]);
            }

            if (Math.min(leftMax, rightMax) > heights[i]) {
                result += Math.min(leftMax, rightMax) - heights[i];
            }
        }

        System.out.println(result);
    }
}
