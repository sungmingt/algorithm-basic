package basic.algorithm.programmers.lv2;

public class 숫자의표현_투포인터 {

    static int solution(int n) {
        int answer = 1; //자기 자신이 포함되기 때문에 미리 1을 더해준다.
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= n / 2) {
            if (sum == n) { //목표숫자라면
                answer++;
                sum -= start;
                start++;
            } else if (sum < n) { //목표보다 작다면
                end++;
                sum += end;
            } else { //목표보다 크다면
                sum -= start;
                start++;
            }
        }

        return answer;
    }
}
