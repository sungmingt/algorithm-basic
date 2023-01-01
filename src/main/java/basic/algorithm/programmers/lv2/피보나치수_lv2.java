package basic.algorithm.programmers.lv2;

public class 피보나치수_lv2 {

    public int solution(int n) { // (A+B) % C  ==  ((A % C) + (B % C)) % C
        int[] num = new int[n+1];
        num[0] = 0;
        num[1] = 1;
        num[2] = 1;

        for(int i=3; i<=n; i++){
            num[i] = (num[i-1] + num[i-2]) % 1234567;
        }

        return num[n];
    }
}
