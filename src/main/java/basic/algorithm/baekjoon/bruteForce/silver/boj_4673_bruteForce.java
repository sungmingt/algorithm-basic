package basic.algorithm.baekjoon.bruteForce.silver;

public class boj_4673_bruteForce {

    static boolean[] arr = new boolean[10001];

    public static void main(String[] args) {
        //각 수마다 생성자를 10000까지 계속 생성한다. 이미 생성된 경우 skip

        for (int i = 1; i < 10001; i++) {
            if(arr[i]) continue;
            getConstructor(i);
        }

        for (int i = 1; i < 10001; i++) {
            if(!arr[i]) System.out.println(i);
        }
    }

    private static void getConstructor(int num) {
        int sum = num;

        //현재 숫자 + 각 자리수
        while (num != 0) {
            sum += num % 10; //각 자리수 더하기
            num /= 10;
        }

        if(sum > 10000 || arr[sum]) return;

        arr[sum] = true;
        getConstructor(sum);
    }
}
