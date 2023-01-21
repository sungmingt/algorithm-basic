package basic.algorithm.programmers.lv1;

public class 두정수사이의합 {

    public long solution(long a, long b) {
        if (a == b) return a;

        long answer = 0;
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        if ((max - min) % 2 == 0) {
            answer = (max + min) * ((max - min) / 2) + ((max + min) / 2);
        } else {
            answer = (max + min) * (max - min + 1) / 2;
        }

        return answer;
    }
}
