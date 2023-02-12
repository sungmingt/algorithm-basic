package basic.algorithm.programmers.lv2;

public class NN배열자르기_월간코드챌린지 {

    public long[] solution(int n, long left, long right) {
        long[] res = new long[(int)(right - left + 1)];

        for (int i = 0; i <= res.length; i++) {
            int x = (int) ((left / n) + 1);
            int y = (int) ((left % n) + 1);
            left++;

            res[i] = Math.max(x, y);
        }

        return res;
        //1 2 3 4
        //2 2 3 4
        //3 3 3 4
        //4 4 4 4

        //left : 4
        //Math.max(1,1)
    }
}
