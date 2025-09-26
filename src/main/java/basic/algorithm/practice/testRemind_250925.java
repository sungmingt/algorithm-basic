package basic.algorithm.practice;

import java.util.Random;

public class testRemind_250925 {

    public static void main(String[] args) {
        //100000 입력 시 1,000,000 와 같은 형태로 변경

        String[] list = new String[]{"10000000", "1000", "100", "10000", "10000000000000"};
        Random r = new Random();
        int random = r.nextInt(list.length);

        System.out.println(quiz(list[random] + ""));
    }

    private static String quiz(String input) {
        int length = input.length() - 1;
        StringBuilder sb = new StringBuilder();

        //마지막 수는 3의 배수이더라도 콤마(,) 넣으면 안됨
        sb.append(input.charAt(length));

        int idx = 1;

        while (length - idx >= 0) {
            if (idx % 3 == 0) {
                sb.append(",");
            }

            sb.append(input.charAt(length - idx));
            idx++;
        }

        return sb.reverse().toString();
    }
}
