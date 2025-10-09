package basic.algorithm.programmers.lv2;

public class 다음큰숫자_string {
    //https://school.programmers.co.kr/learn/courses/30/lessons/12911

    public int solution(int n) {
        int oneCnt = getCount(n);

        for (int i = n + 1; i <= 1000000; i++) {
            int curOneCnt = getCount(i);

            if (oneCnt == curOneCnt) {
                return i;
            }
        }

        return 0;
    }

    private int getCount(int n) {
        int cnt = 0;
        String binaryString = Integer.toBinaryString(n);

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') cnt++;
        }

        return cnt;
    }
}
