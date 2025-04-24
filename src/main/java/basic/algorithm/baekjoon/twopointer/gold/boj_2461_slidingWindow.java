package basic.algorithm.baekjoon.twopointer.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2461_slidingWindow {

    static int N, M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int skill = Integer.parseInt(st.nextToken());
                students.add(new Student(skill, i));
            }
        }

        Collections.sort(students);

        int[] count = new int[N];
        int total = 0;
        int left = 0;

        for (int right = 0; right < students.size(); right++) {
            int group = students.get(right).group;
            if (count[group]++ == 0) total++;

            while (total == N) {
                int diff = students.get(right).skill - students.get(left).skill;
                answer = Math.min(answer, diff);

                // left 포인터 이동
                int leftGroup = students.get(left).group;
                if (--count[leftGroup] == 0) total--;
                left++;
            }
        }

        System.out.println(answer);
    }

    static class Student implements Comparable<Student> {
        int skill, group;

        public Student(int skill, int group) {
            this.skill = skill;
            this.group = group;
        }

        @Override
        public int compareTo(Student o) {
            return this.skill - o.skill;
        }
    }
}
