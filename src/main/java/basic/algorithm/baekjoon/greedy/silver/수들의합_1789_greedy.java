package basic.algorithm.baekjoon.greedy.silver;

import java.util.Scanner;

public class 수들의합_1789_greedy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        //1 + 2 + 3 + 4 ...
        //S : 11, 현재 : 10, 다음 더할 숫자 : 5
        //sum + 이번에 더할 숫자가 S 보다 큰 경우, 초과해봤자 이번에 더할 숫자보다 작다. 즉, 이번에 더했을때 초과할 경우 최악의 경우에도 바로 이전의 숫자만 빼주면 된다.
        //즉, sum + i가 S보다 크면 count++, count--가 진행될 것이며, 그냥 break 해준다

        long sum = 0;
        int count = 0;

        for (int i = 1; i <= S; i++) {
            if(sum == S || sum + i > S) break;
            sum += i;
            count++;
        }

        System.out.println(count);
    }
}
