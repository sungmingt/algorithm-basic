package basic.algorithm.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class 통계학_2108_정렬 {
    //산술평균 : sum / N (소수점 첫번째 자리에서 반올림)
    //중앙값 : numberList 정렬 후 가운데 값 (length / 2) - 1
    //최빈값 : 가장 많이 사용된 값 (두개 이상일 경우 두번째에서 작은 값)
    //범위 : numberList 정렬 후 numberList[numberList.length -1] - numberList[0]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 0;
        int[] numberList = new int[N]; //입력 숫자들
        int[] numberUsedCount = new int[8001];  //숫자가 사용된 횟수

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            sum += num;
            numberList[i] = num;
            numberUsedCount[num+4000]++; //범위(-4000 ~ 4000)에 음수가 있기 때문에 + 4000을 해주어 저장하고, 꺼낼때도 -4000을 해준다.
        }

        Arrays.sort(numberList);

        boolean isSecond = false; //최빈값 중 두번째인지
        int maxUsedCount = 0;  //가장 많이 사용된 횟수
        int mostUsedNumber = 0; //가장 많이 사용된 숫자

        for (int i = 0; i <numberUsedCount.length; i++) {
            if (numberUsedCount[i] > maxUsedCount) { //이전 최대값보다 클 경우 -> 그냥 최대값 초기화
                maxUsedCount = numberUsedCount[i];
                mostUsedNumber = i - 4000;
                isSecond = true;  //최대값이 나왔기 때문에 다음에 나올 값은 두번째 같은 값이다.
            } else if (numberUsedCount[i] == maxUsedCount) { //이전 최대값과 같을 경우
                if (isSecond) { //두 번째 같은 값일 때만 작업해준다. 세번째 이상은 의미가 없기 때문.
                    mostUsedNumber = i - 4000;
                    isSecond = false; //두번째 값이 나왔으니 false 초기화
                }
            }
        }

        int firstAnswer = (int) Math.round((double) sum / N);
        int secondAnswer = numberList[numberList.length / 2];
        int thirdAnswer = mostUsedNumber;
        int fourthAnswer = numberList[numberList.length - 1] - numberList[0];

        System.out.println(firstAnswer);
        System.out.println(secondAnswer);
        System.out.println(thirdAnswer);
        System.out.println(fourthAnswer);
    }
}
