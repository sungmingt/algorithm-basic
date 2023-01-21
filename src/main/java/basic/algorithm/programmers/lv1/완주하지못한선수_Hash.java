package basic.algorithm.programmers.lv1;

import java.util.HashMap;

public class 완주하지못한선수_Hash {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();

        for (String c : completion) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (String s : participant) {
            if (!hash.containsKey(s) || hash.get(s) == 0) {
                return s;
            }

            hash.replace(s, hash.get(s) - 1);
        }

        return null;
    }
}
