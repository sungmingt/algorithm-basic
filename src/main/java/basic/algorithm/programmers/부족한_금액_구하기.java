package basic.algorithm.programmers;

public class 부족한_금액_구하기 {

    public static long solution(int price, int money, int count) {
        long answer = 0;
        int N = 0;

        long result = recursive(answer, N, price, money, count) * -1;
        return Math.max(result, 0);
    }

    private static long recursive(long answer, int N, int price, int money, int count) {
        if(N == count) return money - answer;
        N++;
        answer += price * N;

        return recursive(answer, N, price, money, count);
    }
}
