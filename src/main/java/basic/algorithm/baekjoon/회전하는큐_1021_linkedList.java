package basic.algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class 회전하는큐_1021_linkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int count = sc.nextInt();

        int totalMoveCount = 0;

        //빈 LinkedList 채우기
        LinkedList<Integer> list = new LinkedList();
        for (int i = 0; i < length; i++) {
            list.add(i+1);
        }

        int[] indexList = new int[count];
        //index 리스트 채우기
        for (int i = 0; i < indexList.length; i++) {
            indexList[i] = sc.nextInt();
        }

        //===============

        for (int i = 0; i < count; i++) {
            int currentLength = list.size();
            int standardIndex = currentLength / 2 + 1;

            //이번 index (index를 1부터 시작으로 fix 할 것이기 때문에 +1)
            int index = list.indexOf(indexList[i])+1;

            //왼쪽이 최선
            if (index <= standardIndex) {
                //index 앞의 요소들을 모두 뒤로 보낸다.
                for (int j = 0; j < index - 1; j++) {
                    Integer temp = list.pollFirst();
                    list.offerLast(temp);
                    totalMoveCount++;
                }
            }

            //오른쪽이 최선
            else {
                //index 뒤의 요소들을 모두 앞으로 보낸다.
                for (int j = 0; j < currentLength - index + 1; j++) {
                    Integer temp = list.pollLast();
                    list.offerFirst(temp);
                    totalMoveCount++;
                }
            }

            //작업이 끝나면 첫번째 요소 poll
            list.pollFirst();
        }

        System.out.println(totalMoveCount);
    }
}
