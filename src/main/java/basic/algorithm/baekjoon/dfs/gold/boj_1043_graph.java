package basic.algorithm.baekjoon.dfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1043_graph {

    static int N, M;
    static List<Party> parties = new ArrayList<>();
    static boolean[][] graph;
    static boolean[] knowsTruth;
    static boolean[] visited;
    static int fakeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];
        knowsTruth = new boolean[N + 1];
        visited = new boolean[N + 1];

        //진실을 아는 사람이 없는 파티이더라도, 거기에 있는 사람 중 다른 파티에서 진실을 말하는 걸 듣게된다면, 과장을 할 수 없다.
        // 만일 1 2 3, 아무도 진실을 모름.
        //  하지만 다른 파티에 1,4가 참여하고, 4가 진실을 안다면, 진실을 말해야하고, 그러면 1 2 3이 있는 파티에서도 과장할수 없음.
        //  즉, 진실을 아는 사람이 있는 파티에 참여하는 사람이 있는 파티에서는 항상 진실을 얘기해야함.

        // set에 진실을 아는 사람들을 모두 저장.
        // 파티를 입력 받으면서 같은 파티에 있는 사람들 모두 저장.
        // 하지만 이렇게 하면 입력 순서에 따라 선후관계가 생겨서 이후 관계를 이전 입력 파티가 반영할수 없음

        //그래프 탐색으로 구현.
        //진실을 아는 사람은 boolean knowsTruth[]로 저장
        //입력 받을때, 같은 파티에 참석하는 사람들을 양방향 그래프로 연결.
        //knowsTruth[i] = true 인 사람들을 그래프 탐색.
        //탐색하면서 true로 변경해준다.
        //이후, 파티를 순회하며 진실을 아는 사람이 있는지 판별.


        //input knowsTruth
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        while (count-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            knowsTruth[num] = true;
        }

        //input relations
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int personCount = Integer.parseInt(st.nextToken());

            ArrayList<Integer> participants = new ArrayList<>();

            for (int k = 0; k < personCount; k++) {
                int personIdx = Integer.parseInt(st.nextToken());
                participants.add(personIdx);
            }

            Party party = new Party(i, participants);
            parties.add(party);

            //양방향 그래프 연결
            for (int k = 0; k < party.participants.size() - 1; k++) {
                for (int p = k + 1; p < party.participants.size(); p++) {
                    int fir = party.participants.get(k);
                    int sec = party.participants.get(p);
                    graph[fir][sec] = true;
                    graph[sec][fir] = true;
                }
            }
        }

        //dfs
        for (int i = 0; i < knowsTruth.length; i++) {
            //진실을 아는 사람일 경우에만 탐색
            if (knowsTruth[i] && !visited[i]) {
                dfs(i);
            }
        }

        for (Party party : parties) {
            boolean isContained = party.participants.stream()
                    .anyMatch(person -> knowsTruth[person]);

            if(!isContained) fakeCount++;
        }

        System.out.println(fakeCount);
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;

        for (int i = 0; i < graph[vertex].length; i++) {
            if (graph[vertex][i] && !visited[i]) {
                knowsTruth[i] = true;
                dfs(i);
            }
        }
    }

    private static class Party {
        int idx;
        List<Integer> participants;

        Party(int idx, List<Integer> participants){
            this.idx = idx;
            this.participants = participants;
        }
    }
}
