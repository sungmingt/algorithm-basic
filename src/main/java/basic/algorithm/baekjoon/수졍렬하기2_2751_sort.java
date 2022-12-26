package basic.algorithm.baekjoon;

import java.util.*;

public class 수졍렬하기2_2751_sort {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>(N);
        for(int i=0; i<N; i++){
            numbers.add(sc.nextInt());
        }

        Collections.sort(numbers);
        for(int number : numbers){
            sb.append(number).append("\n");
        }

        System.out.println(sb);
    }
}
