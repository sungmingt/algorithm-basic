package basic.algorithm.baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_28279_deque {

    static int N;
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    int num = Integer.parseInt(st.nextToken());
                    dq.offerFirst(num);
                    break;
                case 2:
                    num = Integer.parseInt(st.nextToken());
                    dq.offerLast(num);
                    break;
                case 3:
                    if (!dq.isEmpty()) {
                        System.out.println(dq.pollFirst());
                    } else {
                        System.out.println(-1);
                    }

                    break;
                case 4:
                    if (!dq.isEmpty()) {
                        System.out.println(dq.pollLast());
                    } else {
                        System.out.println(-1);
                    }

                    break;
                case 5:
                    System.out.println(dq.size());
                    break;
                case 6:
                    if (dq.isEmpty()) System.out.println(1);
                    else System.out.println(0);

                    break;
                case 7:
                    if (!dq.isEmpty()) {
                        System.out.println(dq.peekFirst());
                    } else {
                        System.out.println(-1);
                    }

                    break;
                case 8:
                    if (!dq.isEmpty()) {
                        System.out.println(dq.peekLast());
                    } else {
                        System.out.println(-1);
                    }

                    break;
            }
        }

        //1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
        //2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
        //3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
        //4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
        //5: 덱에 들어있는 정수의 개수를 출력한다.
        //6: 덱이 비어있으면 1, 아니면 0을 출력한다.
        //7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
        //8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
    }
}
