package basic.algorithm.practice;

import java.util.Random;

public class testRemind2_250925 {

    //적립금 계산
    //조건1: 적립금은 5%이다.
    //조건2: 최소 적립금은 1000원이다.
    //조건3: 최대 적립금은 30000원이다.
    //조건4: 10의 자리 이하의 수는 제외한다. ex)1350 -> 1300

    public static void main(String[] args) {
        int[] list = new int[]{1000, 10000, 37600, 51700, 1500000};
        Random r = new Random();
        int random = r.nextInt(list.length);

        System.out.println(getPoints(list[random]));
    }


    private static int getPoints(int amount) {
        int tempPoint = (int) Math.floor(amount * 0.05);

        if (tempPoint < 1000) {
            return 1000;
        }else if (tempPoint > 30000) {
            return 30000;
        }

        if (tempPoint % 100 != 0) {
            //위에서 이미 범위를 1000<point<30000 으로 고정시켰기때문에, 35 와 두 자리수를 고려하지 않아도 된다.
            tempPoint -= tempPoint % 100;
        }

        return tempPoint;
    }
}
