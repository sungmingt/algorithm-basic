package basic.algorithm.baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 소수찾기_1978 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        List<Integer> list = new ArrayList();

        for(int i=0; i<length; i++){
            int num = sc.nextInt();
            int count = 0;

            if(num == 1) count++;

            for(int j=2; j<num; j++){
                if(num % j == 0) count ++;
            }

            if(count == 0) list.add(num);
        }

        System.out.println(list.size());
    }
}
