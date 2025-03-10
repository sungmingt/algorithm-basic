package basic.algorithm.baekjoon.dataStructure.queue.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1065 {

    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //110 99
        //1 2 3 4 5 6 7 8 9 10 11 12... 99, (100~110은 x, 즉 101도 아니기 때문에 3자리일경우 123 가능)

        //500
        //1~99,
        //111, 123, 135, 147, 159, 210, 222, 234, 246, 258,
        //321, 333, 345, 357, 369, 420, 432, 444, 456, 468
        //-> 99 + 20 = 총 119개

        //두자리 수일 경우, 무조건 한수이다.
        if (N <= 99) {
            answer = N;
            System.out.println(answer);
            return;
        }

        //결국 두 자리수는 모두 한수이며, 최대값이 1000이기때문에, 세 자리수만 생각하면 된다.
        //한수가 되려면?
        //  0 <= 첫번째 자리수 - (k * 2)
        //  첫번째 자리수 + (k * 2) <= 9
        //      여기서 k*2는 세번째 자리수

        //첫번째 자리수를 증가시키며 순회하는 반복문을 통해 각 자리수마다 위 조건을 적용시키며 한수를 찾는다.
        //첫번째 자리수가 현재 반복문의 첫번째 자리수와 같을 수 있기때문에, 항상 N과 비교하여 작은 값만 찾는다.
        //t는 최소 0부터 4까지 가능!

        for (int i = 1; i <= N / 100; i++) {
            int first = i;
            
            for (int k = 0; k <= 4; k++) {
                getLower(first, k);
                getHigher(first, k);
            }

            //111과 같이 차이가 0인 경우, 두 함수 모두에 적용될 수 있으므로,
            //  만일 차이가 0일때의 수가 N보다 작거나 같다면, 중복 제거를 위해 -1
            if (first * 100 + first * 10 + first <= N) {
                answer--;
            }
        }

        System.out.println(answer + 99);
    }

    static void getLower(int first, int k) {
        int second = first - k;
        int third = second - k;

        if (0 <= third) {
            int lowerNum = first * 100 + second * 10 + third;

            if (lowerNum <= N) {
                answer++;
            }
        }
    }

    static void getHigher(int first, int k) {
        int second = first + k;
        int third = second + k;

        if (third <= 9) {
            int higherNum = first * 100 + second * 10 + third;

            if (higherNum <= N) {
                answer++;
            }
        }
    }
}
