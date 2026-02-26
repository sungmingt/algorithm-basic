package basic.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class valid_parentheses_stack {

    //https://leetcode.com/problems/valid-parentheses/description/

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }


        //각 제품의 개수를 저장해야함.
        //특정 범위에서 제품의 개수를 모두 만족하는 경우에만 구매.

        //특정 범위 탐색 -> 투포인터?
        //1~10일 까지의 범위를 최초 탐색.
        //이후, right와 left를 이동하면서 탐색

        for(int i=0; i<10; i++) {
            String product = discount[i];
            if(map.containsKey(product)) {
                int prevCount = map.get(product);
                map.put(product, prevCount - 1);
            }
        }


        List<String> keys = map.keySet().stream()
                .collect(Collectors.toList());

        boolean canBuy = true;

        for (int k = 0; k < keys.size(); k++) {
            String key = keys.get(k);
            if(map.get(key) != 0) {
                canBuy = false;
                break;
            }
        }

        if(canBuy) answer++;


        for(int i=10; i<discount.length; i++) {
            String next = discount[i];
            String prev = discount[i-10];

            map.put(next, map.get(next) - 1);
            map.put(prev, map.get(prev) + 1);

            keys = map.keySet().stream()
                    .collect(Collectors.toList());

            canBuy = true;

            for (int k = 0; k < keys.size(); k++) {
                String key = keys.get(k);
                if(map.get(key) != 0) {
                    canBuy = false;
                    break;
                }
            }

            if(canBuy) answer++;
        }

        return answer;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) return false;

            char prev = stack.pop();
            if (c == ')' && prev != '(') return false;
            if (c == ']' && prev != '[') return false;
            if (c == '}' && prev != '{') return false;
        }

        return stack.isEmpty();
    }
}
