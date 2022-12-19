package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 소수_2581 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int min = 0;
        int total = 0;
        boolean isMin = true;

        for (int i = M; i <= N; i++) {
            boolean isSosu = true;

            //1인 경우
            if (i == 1) continue;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){
                    isSosu = false;
                    break;
                }
            }

            //소수인 경우
            if (isSosu) {
                //최소값인 경우
                if(isMin){
                    min = i;
                    isMin = false;
                }
                total += i;
            }
        }

        if(total == 0) System.out.println(-1);
        else{
            System.out.println(total);
            System.out.println(min);
        }
    }
}
