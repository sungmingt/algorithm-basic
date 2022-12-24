package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 더하기사이클_1110 {

    static int initFirstNum;  //초기값
    static int initSecondNum; //초기값
    static int cycle;  //사이클 횟수

    public static void main(String[] args) {
        //다음 firstNum : secondNum
        //다음 secondNum : firstNum + secondNum
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int firstNum = 0;
        int secondNum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                firstNum = str.charAt(i) - '0';
            } else {
                secondNum = str.charAt(i) - '0';
            }
        }

        //초기값 지정
        initFirstNum = firstNum;
        initSecondNum = secondNum;
        doCycle(firstNum, secondNum);

        System.out.println(cycle);
    }

    public static int doCycle(int firstNum, int secondNum) {
        int tempFirst = firstNum; //아래에서 firstNum이 변하기 때문에 임시 저장
        //firstNum 대입
        firstNum = secondNum;

        //secondNum 대입 (firstNum + secondNum 이 두자릿수가 될 경우에 일의자리를 secondNum에 대입한다)
        secondNum = tempFirst + secondNum >= 10 ? (tempFirst + secondNum) % 10 : tempFirst + secondNum;

        cycle++;

        //초기값으로 돌아올 경우 return
        if (firstNum == initFirstNum && secondNum == initSecondNum) {
            return cycle;
        }

        return doCycle(firstNum, secondNum);
    }
}
