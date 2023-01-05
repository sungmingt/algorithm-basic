package basic.algorithm.baekjoon.greedy.silver;

import java.util.Scanner;

public class 잃어버린괄호_1541_greedy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        //1. -를 기준으로 쪼갠다.  {50 - 40 + 50 - 30} -> {50, 50+40, 30}
        //2. -쪼개진 배열 요소 마다 +를 기준으로 쪼개어 본다.  {50, {50, 40}, 30}
        //3. 순회하며 쪼개어진 배열 먼저 + 계산 후, - 동작을 실행한다.

        String[] split = command.split("-");
        int totalSum = 0;

        for (int i = 0; i < split.length; i++) { //-가 없고 +로만 이루어져있을 경우에도 동작한다. split.length = 1이 되기 때문
            String numberOrPlus = split[i];  //50
            String[] splitByPlus = numberOrPlus.split("\\+"); //+ 기준으로 잘라서 더하기를 실행해준다.

            int plusSum = 0;
            for (int j = 0; j < splitByPlus.length; j++) {
                plusSum += Integer.valueOf(splitByPlus[j]);
            }

            if(i == 0) totalSum += plusSum;  //첫 요소이면 더해줘야 한다.
            else totalSum -= plusSum;  //첫 요소가 아니면 -를 기준으로 split 했기 때문에 - 해준다.
        }

        System.out.println(totalSum);
    }
}
