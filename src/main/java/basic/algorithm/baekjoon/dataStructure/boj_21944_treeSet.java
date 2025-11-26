package basic.algorithm.baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class boj_21944_treeSet {

    static int N, M;
    static TreeSet<Question> questions = new TreeSet<>();
    static Map<Integer, TreeSet<Question>> algorithms = new HashMap<>();
    static Map<Integer, Question> info = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //알고리즘별로 문제를 분류할수 있어야한다.
        //난이도(1순위), idx(2순위) 기준으로 정렬하고, 양쪽으로 조회 가능해야한다.
        // -> treeSet의 first(),last(),floor(),ceiling()
        //요소를 추가 할 수 있어야한다.
        //idx로 요소를 삭제 할수 있어야한다.

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int al = Integer.parseInt(st.nextToken());
            Question question = new Question(al, idx, level);

            questions.add(question);
            algorithms.computeIfAbsent(al, key -> new TreeSet<>())
                    .add(question);
            info.put(idx, question);
        }

        M = Integer.parseInt(br.readLine());

        //run command
        for (int i = 0; i < M; i++) {
            doCommand(br.readLine());
        }

        System.out.println(sb);
    }

    private static class Question implements Comparable<Question>{
        int algorithm;
        int idx;
        int level;

        Question(int algorithm, int idx, int level) {
            this.algorithm = algorithm;
            this.idx = idx;
            this.level = level;
        }

        @Override
        public int compareTo(Question q) {
            return this.level == q.level ? this.idx - q.idx : this.level - q.level;
        }
    }

    private static void doCommand(String cmd) {
        StringTokenizer st = new StringTokenizer(cmd);
        String command = st.nextToken();

        switch (command) {
            case "recommend" -> handleRecommend(st);
            case "recommend2" -> handleRecommend2(st);
            case "recommend3" -> handleRecommend3(st);
            case "add" -> handleAdd(st);
            case "solved" -> handleSolved(st);
        }
    }

    private static void handleSolved(StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());
        Question targetQuestion = info.get(idx);

        //remove
        algorithms.get(targetQuestion.algorithm).remove(targetQuestion);
        questions.remove(targetQuestion);
        info.remove(idx);
    }

    private static void handleAdd(StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());
        int level = Integer.parseInt(st.nextToken());
        int al = Integer.parseInt(st.nextToken());
        Question question = new Question(al, idx, level);

        questions.add(question);
        algorithms.computeIfAbsent(al, key -> new TreeSet<>())
                .add(question);
        info.putIfAbsent(idx, question);
    }

    private static void handleRecommend3(StringTokenizer st) {
        int x = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Question std = new Question(-1, -1, L);

        if (x == 1) {
            Question ceiling = questions.ceiling(std);
            if (Objects.isNull(ceiling)) {
                sb.append(-1).append("\n");
            } else {
                sb.append(ceiling.idx).append("\n");
            }
        } else {
            Question floor = questions.floor(std);
            if (Objects.isNull(floor)) {
                sb.append(-1).append("\n");
            } else {
                sb.append(floor.idx).append("\n");
            }
        }
    }

    private static void handleRecommend2(StringTokenizer st) {
        int x = Integer.parseInt(st.nextToken());

        if (x == 1) {
            int idx = questions.last().idx;
            sb.append(idx).append("\n");
        } else {
            int idx = questions.first().idx;
            sb.append(idx).append("\n");
        }
    }

    private static void handleRecommend(StringTokenizer st) {
        int G = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        TreeSet<Question> q = algorithms.get(G);

        if (x == 1) {
            int idx = q.last().idx;
            sb.append(idx).append("\n");
        } else {
            int idx = q.first().idx;
            sb.append(idx).append("\n");
        }
    }
}
