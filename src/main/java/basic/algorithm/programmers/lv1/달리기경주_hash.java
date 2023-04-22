package basic.algorithm.programmers.lv1;

import java.util.*;

public class 달리기경주_hash {

    private static Map<String, Integer> ranks = new HashMap<>();

    public String[] solution(String[] players, String[] callings) {
        initializeRank(players);

        for (String player : callings) {
            Integer curIdx = ranks.get(callings);
            String prevPlayer = players[curIdx - 1];
            players[curIdx - 1] = prevPlayer;
            players[curIdx] = player;

            ranks.put(prevPlayer, curIdx);
            ranks.put(player, curIdx - 1);
        }

        return players;
    }

    private void initializeRank(String[] players) {
        for (int i = 0; i < players.length; i++) {
            ranks.put(players[i], i);
        }
    }
}
