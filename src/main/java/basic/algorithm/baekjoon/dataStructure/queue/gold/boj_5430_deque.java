package basic.algorithm.baekjoon.dataStructure.queue.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_5430_deque {

    static int T;
    static String command;
    static Deque<Integer> deq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            command = br.readLine();
            deq = new ArrayDeque<>();

            int arrLength = Integer.parseInt(br.readLine());

            //입력 파싱 방법 -> StringTokenizer을 사용하면 간단하게 파싱할수있다.
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            while (st.hasMoreTokens()) {
                deq.offerLast(Integer.parseInt(st.nextToken()));
            }

            boolean isError = false;
            boolean isReverse = false;

            //배열을 어떻게 뒤집지?? deq에서 뒤집는 연산을 아무리 시도해도 안됐음.
            //  -> 뒤집는게 아닌, isReverse 를 통해 뒤집어져있는 경우와 아닌 경우에 따라 'D' 명령어 연산을 반대로 처리하면 된다.

            for (int i = 0; i < command.length(); i++) {
                char curCmd = command.charAt(i);

                if (curCmd == 'R') {
                    isReverse = !isReverse;
                } else if (curCmd == 'D') {
                    if (deq.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        //뒤집어져 있는 경우 -> 뒤의 요소를 제거하면 된다.
                        if (isReverse) {
                            deq.pollLast();
                        } else {
                            deq.pollFirst();
                        }
                    }
                }
            }

            if (isError) {
                answer.append("error").append("\n");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                //배열이 비어있을 수 있기 때문에, 요소가 있는 경우에만 요소 + 콤마를 append
                if (!deq.isEmpty()) {
                    if (isReverse) {
                        while (!deq.isEmpty()) {
                            sb.append(deq.pollLast()).append(",");
                        }
                    } else {
                        while (!deq.isEmpty()) {
                            sb.append(deq.pollFirst()).append(",");
                        }
                    }

                    sb.deleteCharAt(sb.length() - 1);
                }

                sb.append("]");
                answer.append(sb).append("\n");
            }
        }

        System.out.println(answer);
    }
}