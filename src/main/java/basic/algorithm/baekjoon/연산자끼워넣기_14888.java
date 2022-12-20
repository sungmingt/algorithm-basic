package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 연산자끼워넣기_14888 { //백트래킹 문제
    //DFS를 이용해 구해야 한다. 연산자 순서에 따라 결과값이 다르고 예측하기 힘들기 때문에, 모든 연산결과를 끝까지 탐색 후 최대/최소를 비교한다.

    static int numberCount; //숫자 개수
    static int[] numbers;   //숫자들
    static int[] operators = new int[4]; //연산자 (차례로 덧셈+, 뺄셈-, 곱셈*, 나눗셈/)
    static int max = Integer.MIN_VALUE;  //최대값
    static int min = Integer.MAX_VALUE;  //최소값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        numberCount = sc.nextInt();
        numbers = new int[numberCount];

        //숫자 입력받기
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = sc.nextInt();
        }

        //연산자 입력받기
        for (int i = 0; i < operators.length; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int depth) {  //num은 연산 결과값, depth는 1부터 시작
        if(depth == numberCount){ //모든 숫자를 다 순회했을 때 재귀 종료
            if(max < num) max = num;  //최대값 비교
            if(min > num) min = num;  //최소값 비교
            return;
        }

        for (int i = 0; i < operators.length; i++) {

            if(operators[i] <= 0 ) continue;  //해당 연산자가 없으면 생략
            operators[i]--;  //사용한 연산자를 - 해준다. 재귀 호출 시 다시 사용되면 안되므로

            switch (i) {
                case 0 :
                    dfs(num + numbers[depth], depth + 1); //연산 결과값과 depth+1 한 값 넣어 재귀 호출
                    break;
                case 1 :
                    dfs(num - numbers[depth], depth + 1);
                    break;
                case 2 :
                    dfs(num * numbers[depth], depth + 1);
                    break;
                case 3 :
                    dfs(num / numbers[depth], depth + 1);
                    break;
            }

            operators[i]++; //재귀 호출이 끝난 부분이기 때문에, 연산자들의 개수를 다시 돌려놓는다.
        }
    }
}
