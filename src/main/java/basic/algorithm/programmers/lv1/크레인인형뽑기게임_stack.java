package basic.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 크레인인형뽑기게임_stack {

    static int solution(int[][] board, int[] moves) {
        //바구니에 같은 인형이 두개가 쌓이면 터진다.
        int answer = 0;

        //인형뽑기칸
        List<Stack<Integer>> list = new ArrayList<>();

        //바구니칸
        Stack<Integer> basket = new Stack<>();

        //list 채우기 (list : 1부터 시작, moves도 1부터 시작)
        for (int i = 0; i < board[0].length+ 1; i++) {
            list.add(new Stack<>());
        }

        //board[4][0] ~ board[0][0]  ->  list(1)
        //board[4][1] ~ board[0][1]  ->  list(2)
        //stack 채우기
        for (int i = 0; i < board[0].length; i++) {
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] != 0) list.get(i + 1).push(board[j][i]);
            }
        }

        for (int i = 0; i < moves.length; i++) {
            //비어있지 않다면 인형을 뽑는다
            if (!list.get(moves[i]).isEmpty()) {
                Integer doll = list.get(moves[i]).pop();

                //바구니의 인형이 동일한경우 터트린다
                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(doll);
                }
            }
        }

        return answer;
    }
}
