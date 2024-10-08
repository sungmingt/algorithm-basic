package basic.algorithm.programmers.lv2;

public class 멀리뛰기 {

    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    static long[] dp;
    static long solution(int n) {
        //2 = 2
        //3 = 3
        //4 = 5
        //f(n) = f(n-1) + f(n-2)

        long answer = 0;

        dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        if (n < 2) {
            return dp[n] % 1234567;
        } else {
            for (int i = 2; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }
        }
//        recursive(n);

        return dp[n];
    }

    static long recursive(int x) {
        if(x <= 3){
            dp[x] = x;
            return x;
        }

        if (dp[x] != 0) return dp[x];
        dp[x] = recursive(x - 1) + recursive(x - 2);

        return dp[x];
    }
}
