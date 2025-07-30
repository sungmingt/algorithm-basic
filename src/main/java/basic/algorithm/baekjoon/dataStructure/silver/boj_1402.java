package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1402 {

    static int N;
    static long A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            //A의 약수들을 구한다.
            //약수들을 2개, 3개, ... 뽑아서 A를 만들수 있을것이다.
            //이때, 그 약수들의 합이 B가 될수있는지 판별

            //ex) 6
            //1 6, 2 3, 1 2 3

            //ex) 24
            //1,2,3,4,6,8,12,24
            //1 24, 2 12, 3 8, 4 6, 2 3 4

            //-> 언제나 1은 곱할수 있으므로, B-1을 성립해도 ok

        }
    }
}
