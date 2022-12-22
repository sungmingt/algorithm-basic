package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 캠핑_4796_greedy {

    static int result = 0;
    static int caseNum = 1;

    public static void main(String[] args) {
        //연속하는 8일동안 5일 사용가능 / 휴가는 20일
        //연속하는 8일동안 5일 사용가능 / 휴가는 17일

        // 첫 8일간 5일 사용 -> 12 / 5
        // 두번째 8일간 5일 사용 -> 4 / 10
        // 세번째 8일중 4일 사용 -> 0 / 14

        //V가 P보다 크다면 -> 항상 result += L, V -= P
        //V가 P보다 작다면 -> V가 L보다 크다면 result += L
        //               -> V가 L보다 작다면 result += V

        Scanner sc = new Scanner(System.in);

        while (true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();

            if(L == 0 && P == 0 && V == 0) break;

            recursive(L, P, V);
        }
    }

    public static void recursive(int L, int P, int V) {
        if (V >= P) {
            result += L;
            V -= P;
            recursive(L, P, V);
        }else {
            if (V >= L) {
                result += L;
                printAndReturn(caseNum, result);
                return;
            } else {
                result += V;
                printAndReturn(caseNum, result);
                return;
            }
        }
    }

    public static void printAndReturn(int caseNum, int result) {
        System.out.println("Case " + caseNum + ": " + result);
        result = 0;
        caseNum++;
    }
}
