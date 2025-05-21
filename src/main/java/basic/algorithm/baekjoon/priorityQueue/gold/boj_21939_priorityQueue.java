package basic.algorithm.baekjoon.priorityQueue.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_21939_priorityQueue {

    static int N, M;

    //오름차순 정렬
    static Queue<Question> easyList = new PriorityQueue<>(new Comparator<Question>() {
        @Override
        public int compare(Question o1, Question o2) {
            return (o1.level == o2.level) ? o1.num - o2.num : o1.level - o2.level;
        }
    });

    //내림차순 정렬
    static Queue<Question> hardList = new PriorityQueue<>(new Comparator<Question>() {
        @Override
        public int compare(Question o1, Question o2) {
            return (o1.level == o2.level) ? o2.num - o1.num : o2.level - o1.level;
        }
    });

    static Map<Integer, Integer> questions = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //input questions
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            questions.put(num, level);
            easyList.offer(new Question(num, level));
            hardList.offer(new Question(num, level));
        }

        //input command
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            //처음 또는 마지막을 꺼낸다.
            //특정 요소를 제거한다.
            //특정 요소를 추가한다.

            if (cmd.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                questions.put(num, level);
                easyList.offer(new Question(num, level));
                hardList.offer(new Question(num, level));

            } else if (cmd.equals("solved")) {
                int num = Integer.parseInt(st.nextToken());
                questions.remove(num);
            } else if (cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    while (true) {
                        Question hardest = hardList.peek();
                        if (questions.containsKey(hardest.num) && questions.get(hardest.num) == hardest.level) {
                            sb.append(hardest.num).append("\n");
                            break;
                        }

                        hardList.poll(); //유효하지 않은 문제(이미 solved 된 문제)이면 삭제.
                    }
                } else if (x == -1) {
                    while (true) {
                        Question easiest = easyList.peek();
                        if (questions.containsKey(easiest.num) && questions.get(easiest.num) == easiest.level) {
                            sb.append(easiest.num).append("\n");
                            break;
                        }

                        easyList.poll(); //유효하지 않으면 삭제
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static class Question {
        int num, level;

        Question(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }
}
