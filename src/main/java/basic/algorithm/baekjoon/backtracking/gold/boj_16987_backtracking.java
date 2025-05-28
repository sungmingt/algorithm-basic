package basic.algorithm.baekjoon.backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16987_backtracking {

    static int N;
    static Egg[] eggs;
    static boolean[] isBroken;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        isBroken = new boolean[N];

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(d, w);
        }

        //내구도, 무게
        //계란을 친다 -> 상대 계란의 무게만큼 내구도가 깎인다
        //내구도 0 이하 -> 깨진다.

        //조건
        //  최대한 많은 계란을 깬다.
        //  한 번 친 계란은 다시 들 수 없다.
        //  본인 or 상대 계란을 깨는 방향
        //  깰 수 있고, 최대한 마진이 덜 남도록 깨야한다.
        //  깰 수 있더라도, 다른 것을 깨야하는경우도 있다. -> 백트래킹?

        hit(isBroken, eggs, 0);
        System.out.println(answer);
    }

    //broken, egges를 항상 새로 만들거나 or 값 복구 처리
    static void hit(boolean[] broken, Egg[] eggs, int idx) {
        if (idx == N) {
            int curCnt = 0;

            for (int i = 0; i < N; i++) {
                if (broken[i]) curCnt++;
            }

            answer = Math.max(answer, curCnt);
            return;
        }

        //깨진 계란이라면 다음 계란으로
        if(broken[idx]) {
            hit(broken, eggs, idx + 1);
            return;
        }

        //칠 계란이 없을 경우에 hit() 함수가 호출되어 값을 갱신해야하기 때문에
        boolean hasTarget = false;

        for (int i = 0; i < N; i++) {
            if(broken[i] || idx == i) continue;

            hasTarget = true;

            boolean[] tempBroken = broken.clone();
            Egg[] tempEggs = new Egg[N];
            for (int j = 0; j < N; j++) {
                tempEggs[j] = new Egg(eggs[j].durability, eggs[j].weight);
            }

            Egg egg1 = tempEggs[idx];
            Egg egg2 = tempEggs[i];

            //계란 치기
            egg1.durability -= egg2.weight;
            egg2.durability -= egg1.weight;

            //깨졌다면
            if (egg2.durability <= 0) {
                tempBroken[i] = true;
            }

            if (egg1.durability <= 0) {
                tempBroken[idx] = true;
            }


            hit(tempBroken, tempEggs, idx + 1);
        }

        if (!hasTarget) {
            hit(broken, eggs, idx + 1);
        }
    }

    static class Egg {
        int durability, weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
