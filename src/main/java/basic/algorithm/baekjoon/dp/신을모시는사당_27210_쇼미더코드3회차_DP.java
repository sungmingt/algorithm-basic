package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신을모시는사당_27210_쇼미더코드3회차_DP {

    static int[] dolSang;
    static int curValue;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N개의 돌상이 왼쪽/오른쪽을 바로보고 있다.
        //연속한 돌상에 금칠하려고 한다
        //가능한 많은 금칠 돌상들이 같은 방향을 바라봐야 한다.
        //꺠달음의 양 = |(왼쪽 금색돌상 - 오른쪽 금색돌상)|

        //1 : 왼쪽, 2 : 오른쪽
        //꺠달음의 양의 최대값을 출력

        int N = Integer.parseInt(br.readLine());
        dolSang = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dolSang[i] = Integer.parseInt(st.nextToken());
        }

        //1 기준, 2 기준으로 나누어 계산 후 더 큰 값을 출력한다.
        //1이 나올 경우 : curValue++ 후 max와 비교
        //2가 나올 경우 : 0보다 클 경우에만 curValue--
        //연속된 개수의 최대값을 구해야하기 떄문에, 0이 된 순간 다음 1을 기다리기 위해 초기화된 상태인 것이다.

        //2 기준일때는 반대이며, 각각 구한 후 더 큰 값을 결과값을 max에 넣고 출력
        for (int i = 0; i < dolSang.length; i++) {
            if (dolSang[i] == 1) {
                curValue += 1;
                if(curValue > max) max = curValue;
            } else {
                if (curValue > 0) {
                    curValue -= 1;
                }
            }
        }

        curValue = 0; //현재 값 초기화

        for (int i = 0; i < dolSang.length; i++) {
            if (dolSang[i] == 2) {
                curValue += 1;
                if(curValue > max) max = curValue;
            } else {
                if (curValue > 0) {
                    curValue -= 1;
                }
            }
        }

        //1 1 1 1 2 2 2 1 1 1 1
        //1 1 2 2 2 2 1 1 2 2
        //2 1 2 1 2 2 1 2 1 2
        System.out.println(max);
    }
}
