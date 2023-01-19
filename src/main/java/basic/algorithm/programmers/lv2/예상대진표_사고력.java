package basic.algorithm.programmers.lv2;


public class 예상대진표_사고력 {

    static int solution(int n, int a, int b) {
        int totalRound = 0;
        int round1 = a / 2 + a % 2;
        int round2 = b / 2 + b % 2;

        while (true) {
            totalRound++;

            if (round1 == round2) {
                return totalRound;
            }

            round1 = round1 / 2 + round1 % 2;
            round2 = round2 / 2 + round2 % 2;
        }

        //1 2 3 4 5 6 7 8
        // 1  3  5  7
        //    3  5

        //1 2  3 4  5 6  7 8  9 10  11 12  13 14  15 16
        // 1  3    5  7     9   11     13   15
    }
}
